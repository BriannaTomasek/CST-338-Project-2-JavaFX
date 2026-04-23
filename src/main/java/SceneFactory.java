import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
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

  public static Scene create(SceneType type, Stage stage, DatabaseManager db, Repository repository) {
    switch (type) {
        case LOGIN:
            return LoginScene.create(stage, db);
        case REGISTRATION:
            return RegistrationScene.create(stage, db);
        //case USER:
            //return UserScene.create(stage, db);
        case ADMINDASHBOARD:
            return AdminDashboardScene.create(stage, db);
        //case MAIN: //Vincent
            //return MainScene(stage, db);
        case DASHBOARD: //Vincent
            return buildDashboardScene(stage, db, repository);
        case QUESTIONSEDITOR:
            //This is how to add the questions editor scene
            return QuestionsEditorScene.create(stage);
        default:
            throw new IllegalArgumentException("Invalid scene type: " + type);
        //case USER:
        // This is how to add the user scene
            //return UserScene.create(stage, db);
    }
  }

    /**
     * Creates the dashboard scene
     * @param stage
     * @param db
     * @return scene with 600x400 dimensions
     */
    //Vincent Marinello-Sweeney
    private static Scene buildDashboardScene(Stage stage, DatabaseManager db, Repository repository) {
        ListView<String> list = new ListView<>();

        list.getItems().addAll(db.getAllUserInfo());

        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            //db.insertName("New User");
            repository.insertName("New User");
            list.getItems().setAll(db.getAllUserInfo());

        });
        Label countLabel = new Label("Users: " + db.getAllUserInfo().size());
        addButton.setOnAction(e-> {
            //db.insertName(nameField.getText());
            list.getItems().setAll(db.getAllUserInfo());
            list.getItems().setAll(db.getAllUserInfo());
        });

        VBox layout = new VBox(15, list, addButton);
        return new Scene(layout, 600, 400);
    }

}
