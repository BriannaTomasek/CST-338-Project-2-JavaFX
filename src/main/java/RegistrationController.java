/**
 * Controller for RegistrationScene validation and logic
 *
 * @author Ariya Briscoe
 * @since 4/18/2026
 */
public class RegistrationController {
    private DatabaseManager db;

    public RegistrationController(DatabaseManager db) {
        this.db = db;
    }

    public String getErrorMessage(String username, String email, String password, String confirmPassword) {
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        } else if (password.length() < 8) {
            return "Password must be at least 8 characters";
        } else if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        } else if (email.isEmpty()) {
            return "Email cannot be empty";
        }
        return "";
    }
}
