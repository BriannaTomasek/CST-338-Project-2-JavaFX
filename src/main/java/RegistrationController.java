/**
 * Controller for RegistrationScene validation and logic
 *
 * @author Ariya Briscoe
 * @since 4/18/2026
 */
public class RegistrationController {

    public String getErrorMessage(String password, String confirmPassword) {
        if (password.length() < 8) {
            return "Password must be at least 8 characters";
        } else if (!password.equals(confirmPassword)) {
            return "Passwords do not match";
        }
        return "";
    }
}
