import javafx.scene.effect.DropShadow;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Explanation: Login scene for user login to app. Example Structure for scene layout
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public class LoginScene {

  /**
   * Creates and returns the login scene.
   *
   * @param stage the stage for the scene to be displayed
   * @return the login scene
   */
  public static Scene create(Stage stage, DatabaseManager db) {
    // Constants
    int SCENE_WIDTH = 600;
    int SCENE_HEIGHT = 500;
    String LOGIN_TITLE = "Java Flash Trivia";
    String USERNAME_PROMPT = "Username";
    String PASSWORD_PROMPT = "Password";
    String CARD_OUTLINE = "#E85D04";

    // Title
    Label titleLabel = new Label(LOGIN_TITLE);
    titleLabel.setStyle("-fx-font-size: 32; -fx-font-weight: bold; -fx-text-fill: #FFD900;");

    // Drop shadow for depth on title
    DropShadow titleShadow = new DropShadow();
    titleLabel.setEffect(titleShadow);

    // Flashcards
    Rectangle cardLeft = new Rectangle(0, 20, 120, 160);
    // Rounded corners and styling for flashcards
    cardLeft.setArcWidth(18);
    cardLeft.setArcHeight(18);
    cardLeft.setFill(Color.WHITE);
    cardLeft.setStroke(Color.web(CARD_OUTLINE));
    cardLeft.setStrokeWidth(4);
    cardLeft.setRotate(-15);

    Rectangle cardRight = new Rectangle(130, 20, 120, 160);
    cardRight.setArcWidth(18);
    cardRight.setArcHeight(18);
    cardRight.setFill(Color.WHITE);
    cardRight.setStroke(Color.web(CARD_OUTLINE));
    cardRight.setStrokeWidth(4);
    cardRight.setRotate(15);

    Rectangle cardCenter = new Rectangle(65, 5, 120, 160);
    cardCenter.setArcWidth(18);
    cardCenter.setArcHeight(18);
    cardCenter.setFill(Color.WHITE);
    cardCenter.setStroke(Color.web(CARD_OUTLINE));
    cardCenter.setStrokeWidth(4);

    // Layout cards in a stack
    Pane cardPane = new Pane();
    cardPane.setPrefSize(280, 200);
    cardPane.getChildren().addAll(cardLeft, cardRight, cardCenter);

    // Center the card pane
    HBox cardBox = new HBox(cardPane);
    cardBox.setAlignment(Pos.CENTER);

    // Username field
    TextField usernameField = new TextField();
    usernameField.setPromptText(USERNAME_PROMPT);
    usernameField.setMaxWidth(360);
    usernameField.setPrefWidth(360);
    usernameField.setStyle(
        "-fx-background-radius: 4; -fx-border-radius: 4; -fx-font-size: 14; -fx-padding: 10;");

    // Password field
    PasswordField passwordField = new PasswordField();
    passwordField.setPromptText(PASSWORD_PROMPT);
    passwordField.setMaxWidth(360);
    passwordField.setPrefWidth(360);
    passwordField.setStyle(
        "-fx-background-radius: 4; -fx-border-radius: 4; -fx-font-size: 14; -fx-padding: 10;");

    // Buttons
    Button loginButton = new Button("Log in");
    Button signUpButton = new Button("Sign up");

    // Styling buttons
    String buttonStyle =
        "-fx-font-size: 15; -fx-font-weight: bold ; -fx-text-fill: #FFD900; -fx-background-color: transparent;";
    loginButton.setStyle(buttonStyle);
    signUpButton.setStyle(buttonStyle);

    // Button drop shadow for depth
    DropShadow buttonShadow = new DropShadow();
    loginButton.setEffect(buttonShadow);
    signUpButton.setEffect(buttonShadow);

    // Error label
    Label errorLabel = new Label();
    errorLabel.setStyle("-fx-text-fill: red; -fx-font-size: 12;");

    // Disable login button if fields are empty (data binding)
    loginButton.disableProperty().bind(
            usernameField.textProperty().isEmpty().or(passwordField.textProperty().isEmpty())
    );

    // Event handlers with LoginController
    LoginController controller = new LoginController(db);

    loginButton.setOnAction(e -> {
      String username = usernameField.getText();
      String password = passwordField.getText();

      String error = controller.getErrorMessage(username, password);
      if (error.isEmpty()) {
        System.out.println("Login clicked: " + username);
        // Route to ADMINDASHBOARD if username starts with "admin", otherwise USER scene
        if (username.toLowerCase().startsWith("admin")) {
          stage.setScene(AdminDashboardScene.create(stage, db, username));
        } else {
          stage.setScene(SceneFactory.create(SceneType.USER, stage, db));
        }
      } else {
        errorLabel.setText(error);
      }
    });

    // database
    signUpButton.setOnAction(
        e -> stage.setScene(SceneFactory.create(SceneType.REGISTRATION, stage, db)));

    // Layout buttons in HBox
    HBox buttonBox = new HBox(40, loginButton, signUpButton);
    buttonBox.setAlignment(Pos.CENTER);


    // Button and error box together
    VBox buttonSection = new VBox(8, buttonBox, errorLabel);
    buttonSection.setAlignment(Pos.CENTER);


    // Input box (username and password close together)
    VBox inputBox = new VBox(8, usernameField, passwordField);
    inputBox.setAlignment(Pos.CENTER);

    // Layout all elements in a VBox
    VBox root = new VBox(16, titleLabel, cardBox, inputBox, buttonSection);
    root.setPadding(new Insets(30, 20, 40, 20));
    root.setStyle("-fx-background-color: #1A5064;");
    root.setAlignment(Pos.TOP_CENTER);

    Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    return scene;
  }
}
