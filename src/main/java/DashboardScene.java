import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Dashboard scene for displaying users
 * @author Vincent Marinello-Sweeney
 */
public class DashboardScene {
    /**
     * Creates the dashboard scene
     * @param stage
     * @param db
     * @param repository
     * @return scene with 600x400 dimensions
     */
    public static Scene create(Stage stage, DatabaseManager db, Repository repository) {
        ListView<String> list = new ListView<>();

        list.getItems().addAll(db.getAllUserInfo());

        Button addButton = new Button("Add Item");
        addButton.setOnAction(e -> {
            repository.insertName("New User");
            list.getItems().setAll(db.getAllUserInfo());
        });

        Label countLabel = new Label("Users: " + db.getAllUserInfo().size());

        VBox layout = new VBox(15, list, addButton, countLabel);
        return new Scene(layout, 600, 400);
    }
}
