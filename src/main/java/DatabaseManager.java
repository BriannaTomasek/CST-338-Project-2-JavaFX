/**
 * This class creates and edits the database.
 * @author Vincent Marinello-Sweeney
 * created 4/13/26
 * @since 4/13/26
 * @version 3.0 */

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
            Crud crud = new Crud();
            //createDatabaseTables();
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
         * inner class for CRUD operations
         */
        public class Crud {
            /**
             * This creates the tables for the database.
             */
            private void createDatabaseTables() {
                //String createUsersDatabaseQuery = "CREATE DATABASE Users_Database";
                String createUsersTableQuery = """
                CREATE TABLE IF NOT EXISTS Users (
                    userID          INTEGER PRIMARY KEY  AUTOINCREMENT,
                    username        TEXT /*FOREIGN KEY*/ REFERENCES Manage_Questions(username) NOT NULL,
                    email_address   TEXT /*FOREIGN KEY*/ REFERENCES email_address NOT NULL,
                    name            TEXT NOT NULL,
                    password        TEXT NOT NULL,
                    isAdmin         INTEGER NOT NULL DEFAULT 0,
                    done            INTEGER NOT NULL DEFAULT 0,
                    created         TEXT    DEFAULT (datetime('now'))
                )
                """;

                String createManageQuestionsTableQuery = """
                CREATE TABLE IF NOT EXISTS Manage_Questions (
                    userID          INTEGER PRIMARY KEY  AUTOINCREMENT,
                    username        TEXT /*FOREIGN KEY*/ REFERENCES username NOT NULL,
                    email_address   TEXT /*FOREIGN KEY*/ REFERENCES email_address NOT NULL,
                    name            TEXT NOT NULL,
                    question_1      TEXT NOT NULL,
                    question_2      TEXT NOT NULL,
                    question_3      TEXT NOT NULL,
                    question_4      TEXT NOT NULL,
                    question_5      TEXT NOT NULL,
                    question_6      TEXT NOT NULL,
                    question_7      TEXT NOT NULL,
                    done            INTEGER NOT NULL DEFAULT 0,
                    created         TEXT    DEFAULT (datetime('now'))
                )
                """;

                String createResultsTableQuery = """
                CREATE TABLE IF NOT EXISTS Results (
                    userID              INTEGER PRIMARY KEY  AUTOINCREMENT,
                    username            TEXT /*FOREIGN KEY*/ REFERENCES username NOT NULL,
                    email_address       TEXT /*FOREIGN KEY*/ REFERENCES email_address NOT NULL,
                    name                TEXT NOT NULL,
                    question_1_result   TEXT NOT NULL,
                    question_2_result   TEXT NOT NULL,
                    question_3_result   TEXT NOT NULL,
                    question_4_result   TEXT NOT NULL,
                    question_5_result   TEXT NOT NULL,
                    question_6_result   TEXT NOT NULL,
                    question_7_result   TEXT NOT NULL,
                    done                INTEGER NOT NULL DEFAULT 0,
                    created             TEXT    DEFAULT (datetime('now'))
                )
                """;

                /*try (Statement statement = connection.createStatement()) {
                    statement.execute(createUsersDatabaseQuery);
                } catch (SQLException e) {
                    System.err.println("Creation of Users database has failed" + e.getMessage());
                }*/


                try (Statement statement = connection.createStatement()) {
                    statement.execute(createUsersTableQuery);
                } catch (SQLException e) {
                    System.err.println("Creation of Users table has failed" + e.getMessage());
                }

                try (Statement statement = connection.createStatement()) {
                    statement.execute(createManageQuestionsTableQuery);
                } catch (SQLException e) {
                    System.err.println("Creation of Manage_Questions table has failed" + e.getMessage());
                }

                try (Statement statement = connection.createStatement()) {
                    statement.execute(createResultsTableQuery);
                } catch (SQLException e) {
                    System.err.println("Creation of Results table has failed" + e.getMessage());
                }

            }
            /**
             * These are insert queries for the database.
             */
            public void insertEntries (String name){
                String sqlQuery200 = "INSERT INTO Users (username) VALUES (?)";

                String sqlQuery5 = """
                        INSERT INTO user
                        (Username, Email_Address, Password, IsAdmin)
                        """;


                try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery200)) {
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
                    List<String> userStringList = new ArrayList<>();

                    String userIDQuery =
                            "SELECT * FROM Users WHERE userID = Users.userID";

                    String usernameQuery =
                            "SELECT * FROM Users WHERE username = Users.username";

                    String emailAddressQuery =
                            "SELECT * FROM Users WHERE emailAddress = Users.emailAddress";

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

                    try (Statement statement = connection.createStatement();
                        ResultSet usernameQueryResultSet = statement.executeQuery(usernameQuery);) {

                        while (usernameQueryResultSet.next()) {
                            userStringList.add(usernameQueryResultSet.getString("username"));
                        }
                    } catch (SQLException e) {
                        System.err.println("Failed to get all user information" + e.getMessage());
                    }

                    try (Statement statement = connection.createStatement();
                         ResultSet emailAddressQueryResultSet = statement.executeQuery(emailAddressQuery);) {

                        while (emailAddressQueryResultSet.next()) {
                            userStringList.add(emailAddressQueryResultSet.getString("emailAddress"));
                        }
                    } catch (SQLException e) {
                        System.err.println("Failed to get all user information" + e.getMessage());
                    }

                    try (Statement statement = connection.createStatement();
                         ResultSet passwordQueryResultSet = statement.executeQuery(passwordQuery);) {

                        while (passwordQueryResultSet.next()) {
                            userStringList.add(passwordQueryResultSet.getString("password"));
                        }
                    } catch (SQLException e) {
                        System.err.println("Failed to get all user information" + e.getMessage());
                    }
                    return userStringList;
                }


                /**
                 * These are update queries for the database.
                 */
                public void markDown(int userID) {
                    String sqlUpdate1 = "UPDATE Users SET done = 1 WHERE userID = ?";
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
                public void deleteAnItem(int userID) {
                    String sqlQueryDelete = "DELETE FROM Users WHERE userID = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryDelete)) {
                        preparedStatement.setInt(1, userID);
                        preparedStatement.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("Deletion of item has failed." + e.getMessage());
                    }


                }

        }

}








