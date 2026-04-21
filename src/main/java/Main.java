import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * This class displays a JavaFX app for login and registration.
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public class Main extends Application {
    private DatabaseManager db;

  /**
   * This is the primary stage for the application. Sets initial scene to login scene.
   *
   * @param stage the primary stage for this application
   */
  @Override
  public void start(Stage stage) {
    // Creates the login scene using the SceneFactory
    // and sets it as the initial scene for the stage.
    Scene scene = SceneFactory.create(SceneType.LOGIN, stage);
    stage.setScene(scene);
    stage.show();

    //Create DatabaseManager (Vincent Marinello-Sweeney)
      db = new DatabaseManager();
      //Stage.setTitle("Database Manager");
      //stage.setScene(SceneFactory.create(SceneType.MAIN, stage, db));
      //stage.show();
  }
    /**
     * stop method - window close (Vincent Marinello-Sweeney)
     */
    @Override
    public void stop() {
        if (db != null)
            db.close();
    }

  public static void main(String[] args) {
    launch(args);
  }
}
