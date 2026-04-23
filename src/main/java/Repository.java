/**
 * This class creates and edits the Observer.
 * @author Vincent Marinello-Sweeney
 * created 4/22/26
 * @since 4/22/26
 * @version 1.0
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    DatabaseManager databaseManager = new DatabaseManager();
    private final Connection connection = databaseManager.getConnection();
    private final DatabaseManager db = databaseManager.getDatabaseManagerInstance();

    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        //List<UsersEntries> current = databaseManager.getAllUserInfo();
        List<UsersEntries> current = getAll();

        for(Observer obs : observers) {
            obs.onListChanged(current);
        }
    }

    /**
     * These are insert queries for the database.
     */
    public void insertUserID (int userID) {
        String insertUserIDQuery = "INSERT INTO main.Users (userID) VALUES (?)";
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
        String insertUsernameQuery = "INSERT INTO main.Users (username) VALUES (?)";
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
        String insertEmailAddressQuery = "INSERT INTO main.Users (email_address) VALUES (?)";
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
        String insertNameQuery = "INSERT INTO main.Users (name) VALUES (?)";
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
        String insertPasswordQuery = "INSERT INTO main.Users (password) VALUES (?)";
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
        String insertIsAdminQuery = "INSERT INTO main.Users (isAdmin) VALUES (?)";
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
        String insertDoneQuery = "INSERT INTO main.Users (done) VALUES (?)";
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
        String insertCreatedQuery = "INSERT INTO main.Users (created) VALUES (?)";
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
    };

    /**
     * These are update queries for the database.
     */
    public void updateUsername(String username){
        String updateUsernameQuery = "UPDATE main.Users SET username = username WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateUsernameQuery)) {
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    };

    /**
     * These are update queries for the database.
     */
    public void updateEmailAddress(String email_address){
        String updateEmailAddressQuery = "UPDATE main.Users SET email_address = email_address WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateEmailAddressQuery)) {
            preparedStatement.setString(3, email_address);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    };

    /**
     * These are update queries for the database.
     */
    public void updatePassword(String password){
        String updatePasswordQuery = "UPDATE main.Users SET password = password WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updatePasswordQuery)) {
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    };

    /**
     * These are update queries for the database.
     */
    public void updateIsAdmin(Integer isAdmin){
        String updateIsAdminQuery = "UPDATE main.Users SET isAdmin = isAdmin WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateIsAdminQuery)) {
            preparedStatement.setInt(4, isAdmin);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Update failed" + e.getMessage());
        }
    };


    /**
     * These are SELECT queries for the database.
     */
    public void selectQueries(){
        List<String> userStringList = new ArrayList<>();

        String userIDQuery =
                "SELECT * FROM main.Users WHERE userID = main.Users.userID";

        String usernameQuery =
                "SELECT * FROM main.Users WHERE username = main.Users.username";

        String emailAddressQuery =
                "SELECT * FROM main.Users WHERE email_address = main.Users.email_address";

        String nameQuery =
                "SELECT * FROM main.Users WHERE name = main.Users.name";

        String passwordQuery =
                "SELECT * FROM main.Users WHERE password = main.Users.password";

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
             ResultSet nameQueryResultSet = statement.executeQuery(nameQuery);) {

            while (nameQueryResultSet.next()) {
                userStringList.add(nameQueryResultSet.getString("name"));
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
    };



    /**
     * These are delete queries for the database.
     */
    public void deleteAnItem(int userID) {
        String sqlQueryDelete = "DELETE FROM main.Users WHERE userID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryDelete)) {
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Deletion of item has failed." + e.getMessage());
        }
    };

    /**
     * adds name
     * @param name
     */
    public void add(String name) {
        db.insertName(name);
        notifyObservers();
    }

    /**
     * Marks it done
     * @param userId
     */
    public void markDone(int userId) {
        db.markDone(userId);
        notifyObservers();
    }

    /**
     * Deletes user
     * @param userId
     */
    public void delete(int userId) {
        //db.delete(userID);
        deleteAnItem(userID);
        notifyObservers();
    }


    /**
     * Reads user information
     * @return list
     */
    public List<UsersEntries> getAll() {
        return (List<UsersEntries>) (db.getAllUserInfo());
    }
}
