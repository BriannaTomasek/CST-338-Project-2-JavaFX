/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 1.0 */

import java.rmi.ServerError;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {

    String username = null;
    String emailAddress = null;
    String password = null;
    boolean isAdmin = false;

    private static final String databaseURL = "jdbc:sqlite:app.db";

    private Connection connection;

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

private void createDatabaseTables() {
    String sqlQuery1 = "CREATE DATABASE";
    String sqlQuery2 = """
        CREATE TABLE IF NOT EXISTS user (
            username        TEXT PRIMARY KEY AUTOINCREMENT
            email_address   TEXT FOREIGN KEY NOT NULL
            password        TEXT NOT NULL
            isAdmin         INTEGER NOT NULL
        )
    """;

    try (Statement statement = connection.createStatement()){
        statement.execute(sqlQuery2);
    } catch (SQLException e){
        System.err.println("Creation of tables has failed" + e.getMessage());
    }

    //String sqlQuery3 = """
    // CREATE TABLE IF NOT EXISTS
    // """;

    //String sqlQuery4 = """
    // CREATE TABLE IF NOT EXISTS
    // """;

    String sqlQuery5 = """
            INSERT INTO user
            (Username, Email_Address, Password, Is_User_An_Admin)
            """;
}


    String sqlQuery6 = """
            INSERT INTO user
            (Username, Email_Address, Password, Is_User_An_Admin)
              DatabaseManager(username, emailAddress, password, isAdmin);
            """;


    String sqlQuery100 = "SELECT * FROM user WHERE username == user.username";

    String sqlQuery101 = "SELECT * FROM user WHERE emailAddress == user.emailAddress";

    String sqlQuery102 = "SELECT * FROM user WHERE password == user.password";

    String sqlQuery103 = "SELECT * FROM user WHERE userID == user.userID";



}
