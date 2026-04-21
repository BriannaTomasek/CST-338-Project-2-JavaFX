import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
  public static Scene create(Stage stage, DatabaseManager db) {
    // Layout: Window dimensions in pixels
    int SCENE_WIDTH = 600;
    int SCENE_HEIGHT = 500;

    // Prompts and texts
    String WELCOME_MESSAGE = "Welcome!";
    String LOGOUT =  "Logout";
    String MANAGE_QUESTIONS = "Manage Questions";
    String MANAGE_USERS = "Manage Users";

    // Formatting (Needs adjusting)
    int PADDING = 20;
    int SPACING = 5;
    int BUTTON_SPACING = 50;
    int BUTTON_WIDTH = 200;
    int BUTTON_HEIGHT = 50;

    // Labels
    Label welcome = new Label(WELCOME_MESSAGE);
    Label clickLogout = new Label(LOGOUT);

    // Buttons
    Button manageQuestions = new Button(MANAGE_QUESTIONS);
    Button manageUsers = new Button(MANAGE_USERS);


    // Format: Alignment and Coloring for texts and buttons
    manageQuestions.setTextFill(Color.WHITE);
    manageQuestions.setStyle("-fx-background-color: #FF4D00;");
    manageQuestions.setMinHeight(BUTTON_HEIGHT);
    manageQuestions.setMaxWidth(BUTTON_WIDTH);


    manageUsers.setTextFill(Color.WHITE);
    manageUsers.setStyle("-fx-background-color: #FF4D00");
    manageUsers.setMinHeight(BUTTON_HEIGHT);
    manageUsers.setMaxWidth(BUTTON_WIDTH);

    welcome.setTextFill(Color.GOLD);
    clickLogout.setTextFill(Color.GOLD);



    // Display
    VBox root = new VBox(SPACING, welcome, clickLogout, manageQuestions, manageUsers);
    root.setStyle("-fx-background-color: #1A5064;");
    root.setPadding(new Insets(PADDING));
    root.setAlignment(Pos.CENTER);

    Scene adminDashboardScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

    return adminDashboardScene;

  }

}
