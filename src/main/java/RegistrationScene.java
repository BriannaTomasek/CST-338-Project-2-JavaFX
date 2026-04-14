import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    // TODO: implement registration scene layout here
    Button backButton = new Button("Back to Login");
    backButton.setOnAction(e -> stage.setScene(SceneFactory.create(SceneType.LOGIN, stage)));
    Label label = new Label("Registration Scene");
    VBox layout = new VBox(5, backButton, label);
    layout.setAlignment(Pos.CENTER);
    Scene scene = new Scene(layout, 600, 500);
    return scene;
  }
}
