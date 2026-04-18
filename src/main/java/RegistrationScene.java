import javafx.scene.effect.DropShadow;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Explanation: Registration scene for user registration to app. Example Structure for scene layout
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public class RegistrationScene {

    /**
     * Creates and returns the Registration scene.
     *
     * @param stage the stage for the scene to be displayed
     * @return the Registration scene
     */
    public static Scene create(Stage stage) {
        // TODO: implement registration into Database
        // Constants
        int SCENE_WIDTH = 600;
        int SCENE_HEIGHT = 500;
        String REGISTRATION_TITLE = "Enter at your own peril!";
        String USERNAME_PROMPT = "Create a username";
        String PASSWORD_PROMPT = "Password must be more than 8 characters";
        String CONFIRM_PASSWORD = "Confirm password";
        String VALID_EMAIL = "Enter a valid email address";

        // Title
        Label titleLabel = new Label(REGISTRATION_TITLE);
        titleLabel.setStyle("-fx-font-size: 32; -fx-font-weight: bold; -fx-text-fill: #FFD900;");
        DropShadow titleShadow = new DropShadow();
        titleLabel.setEffect(titleShadow);

        // Username field
        Label usernameLabel = new Label(USERNAME_PROMPT);
        usernameLabel.setStyle("-fx-text-fill: white;");
        TextField usernameField = new TextField();
        usernameField.setMaxWidth(350);
        usernameField.setPrefWidth(350);

        // Password field
        Label passwordLabel = new Label(PASSWORD_PROMPT);
        passwordLabel.setStyle("-fx-text-fill: white;");
        PasswordField passwordField = new PasswordField();
        passwordField.setMaxWidth(350);
        passwordField.setPrefWidth(350);

        // Confirm password field
        Label confirmLabel = new Label(CONFIRM_PASSWORD);
        confirmLabel.setStyle("-fx-text-fill: white;");
        PasswordField confirmField = new PasswordField();
        confirmField.setMaxWidth(350);
        confirmField.setPrefWidth(350);

        // Email field
        Label emailLabel = new Label(VALID_EMAIL);
        emailLabel.setStyle("-fx-text-fill: white;");
        TextField emailField = new TextField();
        emailField.setMaxWidth(350);
        emailField.setPrefWidth(350);

        // Sign up button
        Button signUpButton = new Button("SIGN ME UP!");
        signUpButton.setStyle("-fx-font-size: 18; -fx-padding: 15; -fx-background-color: #FF4D00; -fx-text-fill: white;");

        // Back to login button(top left corner)
        Button backButton = new Button("Back");
        String backButtonStyle = "-fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #FFD900; -fx-background-color: transparent;";
        backButton.setStyle(backButtonStyle);
        backButton.setOnAction(e -> stage.setScene(SceneFactory.create(SceneType.LOGIN, stage)));

        // Top left back button
        HBox topBar = new HBox(backButton);
        topBar.setAlignment(Pos.TOP_LEFT);

        // Layout all elements
        VBox root = new VBox(16,
                topBar,
                titleLabel,
                usernameLabel, usernameField,
                passwordLabel, passwordField,
                confirmLabel, confirmField,
                emailLabel, emailField,
                signUpButton
        );
        root.setStyle("-fx-background-color: #1A5064;");
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        return scene;
    }
}
