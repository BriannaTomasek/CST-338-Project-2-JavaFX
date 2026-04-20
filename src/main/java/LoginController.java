/**
 * Controller for LoginScene validation and logic
 *
 * @author Ariya Briscoe
 * @since 4/18/2026
 */
public class LoginController {

    public String getErrorMessage(String username, String password) {
        if (username.length() < 3) {
            return "Username must be at least 3 characters";
        } else if (password.length() < 8) {
            return "Password must be at least 8 characters";
        }
        return "";
    }
}
