/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 8.0 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseManager {

    String username = null;
    String email_address = null;
    String password = null;
    boolean isAdmin = false;

    private static final String databaseURL = "jdbc:sqlite:project2database.db";

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
    }

    /**
     * This creates the tables for the database.
     */
    private void createTables() {

        String createResultsTableQuery = """
        CREATE TABLE IF NOT EXISTS Results (
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
        CREATE TABLE IF NOT EXISTS Users (
            userID          INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE REFERENCES Results(userID) NOT NULL,
            username        TEXT    REFERENCES Results(username) UNIQUE NOT NULL,
            email_address   TEXT    REFERENCES Results(email_address) UNIQUE NOT NULL,
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
        CREATE TABLE IF NOT EXISTS Manage_Questions (
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
    }

    /**
     * These are insert queries for the database.
     */
    public void insertUserID (int userID) {
        String insertUserIDQuery = "INSERT INTO Users (userID) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserIDQuery)) {
            preparedStatement.setString(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertUsername (String username) {
        String insertUsernameQuery = "INSERT INTO Users (username) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUsernameQuery)) {
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertEmailAddress (String email_address) {
        String insertEmailAddressQuery = "INSERT INTO Users (email_address) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertEmailAddressQuery)) {
            preparedStatement.setString(3, email_address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertName (String name) {
        String insertNameQuery = "INSERT INTO Users (name) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertNameQuery)) {
            preparedStatement.setString(4, name);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertPassword (String password) {
        String insertPasswordQuery = "INSERT INTO Users (password) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertPasswordQuery)) {
            preparedStatement.setString(5, insertPasswordQuery);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertIsAdmin (int isAdmin) {
        String insertIsAdminQuery = "INSERT INTO Users (isAdmin) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertIsAdminQuery)) {
            preparedStatement.setInt(6, isAdmin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertDone (int done) {
        String insertDoneQuery = "INSERT INTO Users (done) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertDoneQuery)) {
            preparedStatement.setInt(7, done);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertCreated (int created) {
        String insertCreatedQuery = "INSERT INTO Users (created) VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertCreatedQuery)) {
            preparedStatement.setInt(8, created);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    }


    /**
     * These are insert queries for the database.
     */
    public void insertFullRow (int userID, String username, String email_address, String name, String password, int isAdmin, int done, int created){
        String insertFullRowQuery = """
              INSERT INTO Users
              (userID, username, email_address, name, password, isAdmin, done, created)
              VALUES (?, ?, ?, ?, ?, ?, ?, ?)
              """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertFullRowQuery)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email_address);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, isAdmin);
            preparedStatement.setInt(7, done);
            preparedStatement.setInt(8, created);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());

        }
    }

    /**
     * These are queries to get information for each user from the database.
     */
    public List<String> getAllUserInfo() {
        List<String> userStringList = new ArrayList<>();

        String notDoneQuery = "SELECT name FROM Users WHERE done = 0 ORDER BY created DESC";

        try (Statement statement = connection.createStatement();
             ResultSet notDoneQueryResultSet = statement.executeQuery(notDoneQuery);) {
            while (notDoneQueryResultSet.next()) {
                userStringList.add(notDoneQueryResultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

        return userStringList;
    }

    /**
     * These are SELECT queries for the database.
     */
    public void selectQueries(){
        List<String> userStringList = new ArrayList<>();

        String userIDQuery =
                "SELECT * FROM Users WHERE userID = Users.userID";

        String usernameQuery =
                "SELECT * FROM Users WHERE username = Users.username";

        String emailAddressQuery =
                "SELECT * FROM Users WHERE email_address = Users.email_address";

        String nameQuery =
                "SELECT * FROM Users WHERE name = Users.name";

        String passwordQuery =
                "SELECT * FROM Users WHERE password = Users.password";

        try (Statement statement = connection.createStatement();
        ResultSet userIDQueryResultSet = statement.executeQuery(userIDQuery);) {
            while (userIDQueryResultSet.next()) {
                userStringList.add(userIDQueryResultSet.getString("userID"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

            /**
             * These are update queries for the database.
             */
            public void updateUsername(String username){
                String updateUsernameQuery = "UPDATE Users SET username = username WHERE userID = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateUsernameQuery)) {
                    preparedStatement.setString(2, username);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Update failed" + e.getMessage());
                }
            }
            /**
             * These are update queries for the database.
             */
            public void updateEmailAddress(String email_address){
                String updateEmailAddressQuery = "UPDATE Users SET email_address = email_address WHERE userID = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateEmailAddressQuery)) {
                    preparedStatement.setString(3, email_address);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Update failed" + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

        try (Statement statement = connection.createStatement();
             ResultSet nameQueryResultSet = statement.executeQuery(nameQuery);) {

            /**
             * These are update queries for the database.
             */
            public void updatePassword(String password){
                String updatePasswordQuery = "UPDATE Users SET password = password WHERE userID = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
                    preparedStatement.setString(4, password);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Update failed" + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

            /**
             * These are update queries for the database.
             */
            public void updateIsAdmin(Integer isAdmin){
                String updateIsAdminQuery = "UPDATE Users SET isAdmin = isAdmin WHERE userID = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(updateIsAdminQuery)) {
                    preparedStatement.setInt(4, isAdmin);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Update failed" + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }
    }

    /**
     * These are markDone statements for the database.
     */
    public void markDone(int userID) {
        String sqlUpdate1 = "UPDATE Users SET done = 1 WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate1)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    /**
     * These are update queries for the database.
     */
    public void updateUsername(String username){
        String updateUsernameQuery = "UPDATE Users SET username = username WHERE userID = ?"
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateUsernameQuery)) {
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }
    /**
     * These are update queries for the database.
     */
    public void updateEmailAddress(String email_address){
        String updateEmailAddressQuery = "UPDATE Users SET email_address = email_address WHERE userID = ?"
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateEmailAddressQuery)) {
            preparedStatement.setString(3, email_address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    /**
     * These are update queries for the database.
     */
    public void updatePassword(String password){
        String updatePasswordQuery = "UPDATE Users SET password = password WHERE userID = ?"
        try (PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    /**
     * These are update queries for the database.
     */
    public void updateIsAdmin(Integer isAdmin){
        String updateIsAdminQuery = "UPDATE Users SET isAdmin = isAdmin WHERE userID = ?"
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateIsAdminQuery)) {
            preparedStatement.setInt(4, isAdmin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    /**
     * These are delete queries for the database.
     */
    public void deleteAnItem(int userID) {
        String sqlQueryDelete = "DELETE FROM Users WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryDelete)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Deletion of item has failed." + e.getMessage());
        }


            // Ariya Briscoe

            /**
             * Registers a new user in the database
             *
             * @param username the username
             * @param email    the email address
             * @param password the password
             * @return true if registration successful, false if username/email already exists
             */
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

    /**
     * Validates login scene
     * Checks to see if the password equals the password
     * @param username
     * @param password
     * @return true if the password equals the password, otherwise returns false
     */
    // Login scene validation (Ariya Briscoe)
    public boolean validateLogin(String username, String password) {
        String query = "SELECT password FROM Users WHERE username = ?";
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
    }

}






