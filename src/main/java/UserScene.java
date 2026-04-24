import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * User scene for regular (non-admin) users
 * @author Ariya Briscoe
 * @since 4/23/2026
 */
public class UserScene {
    public static Scene create(Stage stage, DatabaseManager db) {
        int SCENE_WIDTH = 600;
        int SCENE_HEIGHT = 500;

        Label title = new Label("So, you think you can Java?");
        title.setStyle("-fx-font-size: 32; -fx-text-fill: #FFD900;");

        Button playButton = new Button("Play");
        playButton.setStyle("-fx-font-size: 18; -fx-padding: 15; -fx-background-color: #FF4D00; -fx-text-fill: white; -fx-min-width: 200;");
        // Button set on action
        playButton.setOnAction(e ->
                stage.setScene(GameScene.create(stage, db))
                );

        Button resultsButton = new Button("Results");
        resultsButton.setStyle("-fx-font-size: 18; -fx-padding: 15; -fx-background-color: #FF4D00; -fx-text-fill: white; -fx-min-width: 200;");

        Label logoutLabel = new Label("Logout");
        logoutLabel.setStyle("-fx-text-fill: #FFD900; -fx-font-size: 15; -fx-cursor: hand;");
        logoutLabel.setOnMouseClicked(e -> stage.setScene(SceneFactory.create(SceneType.LOGIN, stage, db)));

        VBox root = new VBox(30, title, playButton, resultsButton, logoutLabel);
        root.setStyle("-fx-background-color: #1A5064;");
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        return scene;
    }
}

