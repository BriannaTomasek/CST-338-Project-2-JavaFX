/**
 * This class creates and edits the Users database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 10.0
 */

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

    }

    /**
     * Gets the instance of the DatabaseManager
     * @return databaseManagerInstance, the instance of the DatabaseManager
     */
    public static DatabaseManager getDatabaseManagerInstance() {
        if (databaseManagerInstance == null)
            databaseManagerInstance = new DatabaseManager();
        return databaseManagerInstance;
    }

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
    }
    
    /**
     * This creates the tables for the database.
     */
    private void createTables() {

        String createUsersTableQuery = """
        CREATE TABLE IF NOT EXISTS Users (
            userID          INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE /*REFERENCES Results(userID)*/ NOT NULL,
            username        TEXT    /*REFERENCES Results(username)*/ UNIQUE NOT NULL,
            email_address   TEXT    UNIQUE NOT NULL,
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



        String createResultsTableQuery = """
        CREATE TABLE IF NOT EXISTS Results (
            userID              INTEGER PRIMARY KEY UNIQUE NOT NULL,
            username            TEXT    UNIQUE NOT NULL,
            email_address       TEXT    UNIQUE NOT NULL,
            name                TEXT    NOT NULL,
            question_result     TEXT    NOT NULL,
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


        String createManageQuestionsTableQuery = """
        CREATE TABLE IF NOT EXISTS Manage_Questions (
            userID          INTEGER /*PRIMARY KEY*/ UNIQUE NOT NULL,
            username        TEXT    UNIQUE NOT NULL,
            name            TEXT    NOT NULL,
            QID             INTEGER PRIMARY KEY UNIQUE NOT NULL,
            question        TEXT    NOT NULL,
            answer1         TEXT    NOT NULL,
            answer2         TEXT    NOT NULL,
            answer3         TEXT    NOT NULL,
            correctAnswer  INTEGER NOT NULL DEFAULT 0,
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
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
        }
    };

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
    };

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
    };

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
    };

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
    };

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
    };

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
    };

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
    };


    /**
     * These are insert queries for the database.
     */
    public void insertFullRow (int userID, String username, String email_address, String name, String password, int isAdmin, int done, int created){
        String insertFullRowQuery = """
              INSERT INTO main.Users
              (userID, username, email_address, name, password, isAdmin, done, created)
              VALUES (?, ?, ?, ?, ?, ?, ?, ?)
              """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertFullRowQuery)) {
            //preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email_address);
            preparedStatement.setString(4, name);
            preparedStatement.setString(5, password);
            //preparedStatement.setInt(6, isAdmin);
            //preparedStatement.setInt(7, done);
            //preparedStatement.setInt(8, created);
            //preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());

        }
    };

    public void insertQuestions (String question, String answer1, String answer2, String answer3, Integer correctAnswer){

        String insertFullRowQuery = """
              INSERT INTO main.Manage_Questions 
              (question, answer1, answer2, answer3, correctAnswer)
              VALUES (?, ?, ?, ?, ?)
              """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertFullRowQuery)) {
            preparedStatement.setString(1, question);
            preparedStatement.setString(2, answer1);
            preparedStatement.setString(3, answer2);
            preparedStatement.setString(4, answer3);
            preparedStatement.setInt(5, correctAnswer);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());

        }
    };

    /**
     * These are queries to get information for each user from the database.
     */
    public List<String> getAllUserInfo() {
        List<String> userStringList = new ArrayList<>();

        String notDoneQuery = "SELECT name FROM Users WHERE done = 0 ORDER BY created DESC";

        try (Statement statement = connection.createStatement()) {
            ResultSet notDoneQueryResultSet = statement.executeQuery(notDoneQuery);
            while (notDoneQueryResultSet.next()) {
                userStringList.add(notDoneQueryResultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }

        return userStringList;
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

    // User registration (Ariya Briscoe)
    public boolean registerUser(String username, String email, String password) {
        String query = "INSERT INTO Users (username, email_address, name, password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

}








