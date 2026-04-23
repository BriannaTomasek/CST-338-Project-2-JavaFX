import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Starter template to log in a user
 */
public class UserScene {
    public static Scene create(Stage stage, DatabaseManager db) {
        Label label = new Label("User Scene");
        VBox root = new VBox(label);
        root.setStyle("-fx-background-color: #1A5064;");
        Scene scene = new Scene(root, 600, 500);
        return scene;
    }

}
