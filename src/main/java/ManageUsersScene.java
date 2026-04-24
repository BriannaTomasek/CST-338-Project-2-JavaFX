import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Jessica Sandoval, Vincent Marinello-Sweeney
 * Description: This class is for the Manage Users scene.
 * @since 4/23/2026
 */
public class ManageUsersScene {



  public static Scene create(Stage stage, DatabaseManager db) {
      //Window dimensions in pixels

      int SCENE_WIDTH = 600;
      int SCENE_HEIGHT = 600;

      VBox root = new VBox();
      Scene questionsEditorScene= new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
      return questionsEditorScene;

      //Window dimensions in pixels
      //final int SCENE_WIDTH = 800;
      //final int SCENE_HEIGHT = 600;

      final String SEARCH_BY_LABEL = "Search by username or email";

      final String ADMIN_LABEL = db.username;

      final String returnButtonString = "Return";
      final String deleteButtonString = "DELETE";

      Label adminLabel = new Label(ADMIN_LABEL);

      Label SearchByUsernameOrEmailLabel = new Label(SEARCH_BY_LABEL);

      TextField usernameField = new TextField();
      TextField emailField = new TextField();

      Button deleteButton = new Button(deleteButtonString);
      Button returnButton = new Button(returnButtonString);


      VBox adminRoot1 = new VBox(15, adminLabel);
      adminRoot1.setPadding(new Insets(30));
      adminRoot1.setAlignment(Pos.TOP_RIGHT);

      VBox centerBox = new VBox(20, SearchByUsernameOrEmailLabel, usernameField, emailField);
      centerBox.setPadding(new Insets(30));
      centerBox.setAlignment(Pos.CENTER);

      VBox everything = new VBox(20, adminRoot1, centerBox);

      Scene scene = new Scene(everything, SCENE_WIDTH, SCENE_HEIGHT);
      stage.setTitle("");
      stage.setScene(scene);
      return scene;
  }

}
