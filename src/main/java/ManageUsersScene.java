import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Jessica Sandoval
 * @Description <br>
 * @since 4/23/2026
 */
public class ManageUsersScene {



  public static Scene create(Stage stage, DatabaseManager db) {
    int SCENE_WIDTH = 600;
    int SCENE_HEIGHT = 600;

    VBox root = new VBox();
    Scene questionsEditorScene= new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
    return questionsEditorScene;
  }
}
