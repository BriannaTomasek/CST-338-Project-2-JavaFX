/**
 * Controller for LoginScene validation and logic
 *
 * @author Ariya Briscoe
 * @since 4/18/2026
 */
public class LoginController {

    private DatabaseManager db;

    public LoginController(DatabaseManager db) {
        this.db = db;
    }

    public String getErrorMessage(String username, String password) {
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        } else if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }
        else if (!db.validateLogin(username, password)) {
            return "Invalid username or password";
        }
        return "";
    }
}
