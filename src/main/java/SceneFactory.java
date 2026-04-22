import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Explanation: This class creates different scenes based on the SceneType and stage.
 * Steps: Each scene is implemented in its own class (LoginScene.java or Dashboard.java etc.). To
 * add a new scene, create yourScene.java Implement : public static Scene create (Stage, stage).
 * Then add a case to the switch statement in the create method of this class. add the scene type to
 * the SceneType enum in SceneType.java
 *
 * @author Ariya Briscoe
 * @since 4/11/2026
 */
public abstract class SceneFactory {

  public static Scene create(SceneType type, Stage stage, DatabaseManager db) {
    switch (type) {
      case LOGIN:
        return LoginScene.create(stage, db);
      case REGISTRATION:
        return RegistrationScene.create(stage, db);
      //case USER:
        //return UserScene.create(stage, db);
      case ADMINDASHBOARD:
        return AdminDashboardScene.create(stage);
      default:
        throw new IllegalArgumentException("Invalid scene type: " + type);
       // case USER:
        // This is how to add the user scene
       // return UserScene.create(stage);
    }
  }
}
