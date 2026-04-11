import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Explanation: Explanation: This class creates different scenes based on the SceneType and stage.
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public abstract class SceneFactory {

  /**
   * This method creates a scene based on the given SceneType and stage. It uses a switch statement
   * @return the scene given
   */
  public static Scene create(SceneType type, Stage stage) {
    switch (type) {
      case LOGIN:
        // TODO: add login scene
        return null;
      case REGISTRATION:
        // TODO: add registration scene
        return null;
      default:
        throw new IllegalArgumentException("Invalid scene type: " + type);
    }
  }

}
