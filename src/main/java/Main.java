import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class displays a JavaFX app for login and registration.
 *
 * @author Ariya Briscoe
 * @since 3/29/2026
 */
public class Main extends Application {
  @Override
  public void start(Stage stage) {
    Scene scene = SceneFactory.create(SceneType.LOGIN, stage);
    stage.setScene(scene);
    stage.setTitle("Login and Registration App goes here");
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}