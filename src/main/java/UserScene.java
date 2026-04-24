import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserScene {

    public static Scene create(Stage stage, DatabaseManager db) {

        Label label = new Label("User Scene");
        Label welcomeLabel = new Label("Welcome, User!");
        Label scoreLabel = new Label("Score: 0");
        Label gamesPlayedLabel = new Label("Games Played: 0");

        Button startGameButton = new Button("Start Game");
        Button logoutButton = new Button("Logout");

        startGameButton.setOnAction(e ->
                System.out.println("Game page coming soon")
        );

        logoutButton.setOnAction(e ->
                stage.setScene(LoginScene.create(stage, db))
        );

        VBox root = new VBox();
        root.setSpacing(15);

        root.getChildren().addAll(
                label,
                welcomeLabel,
                scoreLabel,
                gamesPlayedLabel,
                startGameButton,
                logoutButton
        );

        root.setStyle("-fx-background-color: #1A5064;");

        return new Scene(root, 600, 500);
    }
}
