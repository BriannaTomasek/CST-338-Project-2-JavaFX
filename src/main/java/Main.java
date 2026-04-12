import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class displays a JavaFX app for login and registration.
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public class Main extends Application {

  /**
   * This is the primary stage for the application. Sets initial scene to login scene.
   * @param stage
   */
  @Override
  public void start(Stage stage) {
    // Creates the login scene using the SceneFactory and sets it as the initial scene for the stage.
    Scene scene = SceneFactory.create(SceneType.LOGIN, stage);
    stage.setScene(scene);
    stage.setTitle("Login Scene");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}