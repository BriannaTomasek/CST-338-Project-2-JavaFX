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


public class DatabaseManager {
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


    String query1 = "CREATE DATABASE";
    String query2 = "CREATE TABLE IF NOT EXISTS USER";
    //String query3 = "CREATE TABLE IF NOT EXISTS ";
    //String query4 = "CREATE TABLE IF NOT EXISTS ";

    String username = null;
    String emailAddress = null;
    String password = null;
    boolean isAdmin = false;

    String query5 = """
            INSERT INTO USER
            (Username, Email_Address, Password, Is_User_An_Admin)
            """;
    String query6 = """
            INSERT INTO USER
            (Username, Email_Address, Password, Is_User_An_Admin)
              DatabaseManager(username, emailAddress, password, isAdmin);
              """;


    String query100 =  "SELECT * FROM USER WHERE username == User.username";

    String query102 =  "SELECT * FROM USER WHERE emailAddress == User.emailAddress";

    String query103 =  "SELECT * FROM USER WHERE password == User.password";

    String query101 =  "SELECT * FROM USER WHERE userID == User.userID";



}
