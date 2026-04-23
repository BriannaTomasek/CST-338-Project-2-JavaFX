import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;   // ✅ CORRECT

/**
 * @author Jessica Sandoval
 * @Description This class files represents the scene for the admin dashboard that provides the
 * admin user with the option to either manage users or manage questions that will be used in the
 * game play
 * <br>
 * @since 4/14/2026
 */
public class AdminDashboardScene {
  public static Scene create(Stage stage) {
    return create(stage, "");
  }

  public static Scene create(Stage stage, String username) {
    // Layout: Window dimensions in pixels
    int SCENE_WIDTH = 600;
    int SCENE_HEIGHT = 500;

    // Labels texts
    String WELCOME_MESSAGE = "Welcome, %s!";
    String LOGOUT =  "Logout";
    String MANAGE_QUESTIONS = "Manage Questions";
    String MANAGE_USERS = "Manage Users";


    // Formatting
    int SPACING = 30;
    int TEXT_SIZE = 45;
    int BUTTON_SPACING = 50;
    int BUTTON_WIDTH = 200;
    int BUTTON_HEIGHT = 50;
    int BUTTON_FONT_SIZE = 20;
    int LOGOUT_FONT_SIZE = 15;

    // Creating the labels
    //Label welcome = new Label(String.format(WELCOME_MESSAGE, username));

    Label welcome = new Label(String.format(WELCOME_MESSAGE, username));
    Label clickLogout = new Label(LOGOUT);

    //  Creating the buttons
    Button manageQuestions = new Button(MANAGE_QUESTIONS);
    Button manageUsers = new Button(MANAGE_USERS);

    /* Format: Alignment and Coloring for texts and buttons */

    // Align
    VBox buttonBox = new VBox(BUTTON_SPACING);
    buttonBox.setAlignment(Pos.BASELINE_CENTER);
    buttonBox.getChildren().addAll(manageQuestions, manageUsers);
    manageQuestions.setFont(Font.font(BUTTON_FONT_SIZE));
    manageQuestions.setMinHeight(BUTTON_HEIGHT);
    manageQuestions.setMaxWidth(BUTTON_WIDTH);

    manageUsers.setFont(Font.font(BUTTON_FONT_SIZE));
    manageUsers.setMinHeight(BUTTON_HEIGHT);
    manageUsers.setMaxWidth(BUTTON_WIDTH);

    welcome.setFont(Font.font(TEXT_SIZE));
    VBox.setMargin(welcome, new Insets(30, 0, 0, 0));

    Region spacer = new Region();
    Region spacer2 = new Region();
    Region spacer3 = new Region();
    VBox.setVgrow(spacer, Priority.ALWAYS);

    //Cosmetic coloring
    DropShadow dropShadow = new DropShadow();

    manageQuestions.setTextFill(Color.WHITE);
    manageQuestions.setEffect(dropShadow);
    manageQuestions.setStyle("-fx-background-color: #FF4D00;" +
                             "-fx-border-color: #000000;" +
                             "-fx-border-width: 2px;" +
                             "-fx-background-insets: 0;");

    manageUsers.setTextFill(Color.WHITE);
    manageUsers.setEffect(dropShadow);
    manageUsers.setStyle("-fx-background-color: #FF4D00;" +
                         "-fx-border-color: #000000;" +
                         "-fx-border-width: 2px;" +
                         "-fx-background-insets: 0;" );
    welcome.setTextFill(Color.GOLD);
    welcome.setEffect(dropShadow);
    clickLogout.setTextFill(Color.GOLD);
    clickLogout.setEffect(dropShadow);
    clickLogout.setFont(Font.font(LOGOUT_FONT_SIZE));

    // Display
    VBox root = new VBox(SPACING);
    root.getChildren().addAll(welcome, buttonBox, spacer2, clickLogout, spacer3);
    root.setStyle("-fx-background-color: #1A5064;");
    root.setAlignment(Pos.CENTER);

    Scene adminDashboardScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

    return adminDashboardScene;
  }
}
