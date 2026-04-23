/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 9.0
 * */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseManager {

    String username = null;
    String email_address = null;
    String password = null;
    boolean isAdmin = false;

    private static final String databaseURL = "jdbc:sqlite:project2database.db";

    private static DatabaseManager databaseManagerInstance;

    private Connection connection;

    /**
     * Constructor to manage the database
     * Calls createTables method
     */
    public DatabaseManager(){
        try {
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("The database is now connected.");
            createTables();
        } catch (SQLException e) {
            System.err.println("The connection has failed." + e.getMessage());
        }
        /**
         * Inner class DatabaseManagerInstance
         */
        class DatabaseManagerInstance {
            /**
             * Gets the instance of the DatabaseManager
             * @return databaseManagerInstance, the instance of the DatabaseManager
             */

            public static DatabaseManager getDatabaseManagerInstance() {
                if (databaseManagerInstance == null)
                    databaseManagerInstance = new DatabaseManager();
                return databaseManagerInstance;
            };
        };
    };

    /**
     * Gets the connection
     * @return connection
     */
    public Connection getConnection(){
        return connection;
    }

    /**
     * This method closes the connection.
     */
    public void close(){
        try{
            if (connection != null && !connection.isClosed())
                connection.close();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    };

    /**
     * This creates the tables for the database.
     */
    private void createTables() {

        String createResultsTableQuery = """
        CREATE TABLE IF NOT EXISTS main.Results (
            userID              INTEGER PRIMARY KEY UNIQUE NOT NULL,
            username            TEXT    UNIQUE NOT NULL,
            email_address       TEXT    UNIQUE NOT NULL,
            name                TEXT    NOT NULL,
            question_1_result   TEXT    NOT NULL,
            question_2_result   TEXT    NOT NULL,
            question_3_result   TEXT    NOT NULL,
            question_4_result   TEXT    NOT NULL,
            question_5_result   TEXT    NOT NULL,
            question_6_result   TEXT    NOT NULL,
            question_7_result   TEXT    NOT NULL,
            isAdmin             INTEGER NOT NULL DEFAULT 0,
            done                INTEGER NOT NULL DEFAULT 0,
            created             TEXT    DEFAULT (datetime('now'))
        )
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(createResultsTableQuery);
        } catch (SQLException e) {
            System.err.println("Creation of Results table has failed" + e.getMessage());
        }

        String createUsersTableQuery = """
        CREATE TABLE IF NOT EXISTS main.Users (
            userID          INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE REFERENCES main.Results(userID) NOT NULL,
            username        TEXT    REFERENCES main.Results(username) UNIQUE NOT NULL,
            email_address   TEXT    REFERENCES main.Results(email_address) UNIQUE NOT NULL,
            name            TEXT    NOT NULL,
            password        TEXT    NOT NULL,
            isAdmin         INTEGER NOT NULL DEFAULT 0,
            done            INTEGER NOT NULL DEFAULT 0,
            created         TEXT    DEFAULT (datetime('now'))
        )
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(createUsersTableQuery);
        } catch (SQLException e) {
            System.err.println("Creation of Users table has failed" + e.getMessage());
        }

        String createManageQuestionsTableQuery = """
        CREATE TABLE IF NOT EXISTS main.Manage_Questions (
            userID          INTEGER PRIMARY KEY UNIQUE NOT NULL,
            username        TEXT    UNIQUE NOT NULL,
            email_address   TEXT    UNIQUE NOT NULL,
            name            TEXT    NOT NULL,
            question_1      TEXT    NOT NULL,
            question_2      TEXT    NOT NULL,
            question_3      TEXT    NOT NULL,
            question_4      TEXT    NOT NULL,
            question_5      TEXT    NOT NULL,
            question_6      TEXT    NOT NULL,
            question_7      TEXT    NOT NULL,
            isAdmin         INTEGER NOT NULL DEFAULT 0,
            done            INTEGER NOT NULL DEFAULT 0,
            created         TEXT    DEFAULT (datetime('now'))
        )
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(createManageQuestionsTableQuery);
        } catch (SQLException e) {
            System.err.println("Creation of Manage_Questions table has failed" + e.getMessage());
        }
    };

    /**
     * These are queries to get information for each user from the database.
     */
    public List<String> getAllUserInfo() {
        List<String> userStringList = new ArrayList<>();

        String notDoneQuery = "SELECT name FROM main.Users WHERE done = 0 ORDER BY created DESC";

        try (Statement statement = connection.createStatement()) {
            ResultSet notDoneQueryResultSet = statement.executeQuery(notDoneQuery);
            while (notDoneQueryResultSet.next()) {
                userStringList.add(notDoneQueryResultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

        return userStringList;
    };



    /**
     * These are markDone statements for the database.
     */
    public void markDone(int userID) {
        String sqlUpdate1 = "UPDATE main.Users SET done = 1 WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate1)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    };



    /**
     * Validates login scene
     * Checks to see if the password equals the password
     * @param username
     * @param password
     * @return true if the password equals the password, otherwise returns false
     */
    // Login scene validation (Ariya Briscoe)
    public boolean validateLogin(String username, String password) {
        String query = "SELECT password FROM main.Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("password").equals(password);
            }
        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
        }
        return false;
    };

    public boolean registerUser(String username, String email, String password) {
        String query = "INSERT INTO Users (username, email_address, password, name) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, username);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Registration failed: " + e.getMessage());
            return false;
        }
    }


}








