import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Explanation: Explanation: This class creates different scenes based on the SceneType and stage.
 * Steps: Each scene is implemented in its own class (LoginScene.java or Dashboard.java etc.). To
 * add a new scene, create yourScene.java Implement : public static Scene create (Stage, stage).
 * Then add a case to the switch statement in the create method of this class. add the scene type to
 * the SceneType enum in SceneType.java
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public abstract class SceneFactory {

  /**
   * This method creates a scene based on the given SceneType and stage. It uses a switch statement
   *
   * @return the scene given
   */
  public static Scene create(SceneType type, Stage stage) {
    switch (type) {
      case LOGIN:
        // This is how to add the login scene
        return LoginScene.create(stage);
      case REGISTRATION:
        // This is how to add the registration scene
        return RegistrationScene.create(stage);
      // Adds the Admin user dashboard
      case ADMINDASHBOARD:
        return AdminDashboardScene.create(stage);
      case QUESTIONSEDITOR:
        //This is how to add the questions editor scene
        return QuestionsEditorScene.create(stage);
      default:
        throw new IllegalArgumentException("Invalid scene type: " + type);
    }
  }
}
