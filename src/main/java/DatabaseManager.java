/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 1.0 */

import org.sqlite.SQLiteConfig.*;

import java.rmi.ServerError;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {

    String username = null;
    String emailAddress = null;
    String password = null;
    boolean isAdmin = false;

    private static final String databaseURL = "jdbc:sqlite:project2database.db";

    private Connection connection;

    /**
     * Constructor to manage the database
     * Calls createDatabaseTables method
     */
    public DatabaseManager(){
        try {
            connection = DriverManager.getConnection(databaseURL);
            System.out.println("The database is now connected.");
            createDatabaseTables();
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
    private void createDatabaseTables() {
        String sqlQuery1 = "CREATE DATABASE users_database";
        String sqlQuery2 = """
            CREATE TABLE IF NOT EXISTS users (
                userID          INTEGER PRIMARY KEY  AUTOINCREMENT,
                username        TEXT FOREIGN KEY REFERENCES userID NOT NULL,
                email_address   TEXT FOREIGN KEY REFERENCES email_address NOT NULL,
                password        TEXT NOT NULL,
                isAdmin         INTEGER NOT NULL DEFAULT 0,
                done            INTEGER NOT NULL DEFAULT 0,
                created         TEXT    DEFAULT (datetime('now'))
            )
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery2);
        } catch (SQLException e) {
            System.err.println("Creation of tables has failed" + e.getMessage());
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertEntries(String name){
        String sqlQuery200 = "INSERT INTO users (username) VALUES (?)";

        String sqlQuery5 = """
            INSERT INTO user
            (Username, Email_Address, Password, Is_User_An_Admin)
            """;

        String sqlQuery6 = """
        INSERT INTO user
        (Username, Email_Address, Password, Is_User_An_Admin)
          DatabaseManager(username, emailAddress, password, isAdmin);
        """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery200)) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());

        }
    }

    /**
     * These are queries to get information for each user from the database.
     */
    public List<String> getAllUserInfo() {
        List <String> userstringList  = new ArrayList<>();

        //String sqlQuery1000 = "SELECT userID FROM user WHERE userID == user.userID";

        String sqlQuery100 =
                "SELECT * FROM users WHERE userID == users.userID";

        String sqlQuery101 =
                "SELECT * FROM users WHERE username == users.username";

        String sqlQuery102 =
                "SELECT * FROM users WHERE emailAddress == users.emailAddress";

        String sqlQuery103 =
                "SELECT * FROM users WHERE password == users.password";

        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery100);
            ResultSet resultSet = statement.executeQuery(sqlQuery101);
            ResultSet resultSet = statement.executeQuery(sqlQuery102);
            ResultSet resultSet = statement.executeQuery(sqlQuery103)) {
            while (resultSet.next()){
                userstringList.add(resultSet.getString("userID"));
                userstringList.add(resultSet.getString("username"));
                userstringList.add(resultSet.getString("emailAddress"));
                userstringList.add(resultSet.getString("password"));
            }
        } catch(SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }
        return userstringList;
    }


    /**
     * These are update queries for the database.
     */
    public void markDown(int userID) {
        String sqlUpdate1 = "UPDATE users SET done = 1 WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate1)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    /**
     * These are delete queries for the database.
     */
    public void deleteAnItem (int userID) {
        String sqlQueryDelete = "DELETE FROM users WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryDelete)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            System.err.println("Deletion of item has failed."+e.getMessage());
    }


    //String sqlQuery3 = """
    // CREATE TABLE IF NOT EXISTS
    // """;

    //String sqlQuery4 = """
    // CREATE TABLE IF NOT EXISTS
    // """;
}
}







