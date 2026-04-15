/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 1.0 */

import java.rmi.ServerError;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseManager {

    String username = null;
    String emailAddress = null;
    String password = null;
    boolean isAdmin = false;

    private static final String databaseURL = "jdbc:sqlite:app.db";

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
        String sqlQuery1 = "CREATE DATABASE";
        String sqlQuery2 = """
            CREATE TABLE IF NOT EXISTS user (
                userID          INTEGER FOREIGN KEY  AUTOINCREMENT
                username        TEXT PRIMARY KEY
                email_address   TEXT FOREIGN KEY NOT NULL
                password        TEXT NOT NULL
                isAdmin         INTEGER NOT NULL
            )
        """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery2);
        } catch (SQLException e) {
            System.err.println("Creation of tables has failed" + e.getMessage());
        }
    }

    public void insertEntries(String name){
        String sqlQuery200 = "INSERT INTO user (username) VALUES (?)";

        String sqlQuery5 = """
            INSERT INTO user
            (Username, Email_Address, Password, Is_User_An_Admin)
            """;

        String sqlQuery6 = """
        INSERT INTO user
        (Username, Email_Address, Password, Is_User_An_Admin)
          DatabaseManager(username, emailAddress, password, isAdmin);
        """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery200) {
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Insertion of entries has failed." + e.getMessage());
}
        }
    }

    /**
     * These are queries to get information for each user from the database.
     */
    public List<String> getAllUserInfo() {
        List <String> userStringList  = new ArrayList<>();

        //String sqlQuery1000 = "SELECT userID FROM user WHERE userID == user.userID";

        String sqlQuery100 =
                "SELECT * FROM user WHERE userID == user.userID";

        String sqlQuery101 =
                "SELECT * FROM user WHERE username == user.username";

        String sqlQuery102 =
                "SELECT * FROM user WHERE emailAddress == user.emailAddress";

        String sqlQuery103 =
                "SELECT * FROM user WHERE password == user.password";

        try(Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery100, sqlQuery101, sqlQuery102, sqlQuery103)){
            while (resultSet.next()){
                userStringList.add(resultSet.getString("userID"));
                userStringList.add(resultSet.getString("username"));
                userStringList.add(resultSet.getString("emailAddress"));
                userStringList.add(resultSet.getString("password"));
            }

        } catch(SQLException e) {
            System.err.println("Failed to get all user information" + e.getMessage());
        }
        return userStringList;
    }


    /**
     * These are queries for the database.
     */
    public void update(int userID) {
        String sqlUpdate1 -"UPDATE user SET updated = 1 WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate1)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    }

    public void deleteAnItem (int userID) {
        String sqlQueryDelete = "DELETE FROM user WHERE userID = ?";
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







