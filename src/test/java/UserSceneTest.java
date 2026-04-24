import static org.junit.jupiter.api.Assertions.assertNotNull;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserSceneTest {

    private DatabaseManager db;
    private Repository repository;


    public void start(Stage stage){
        db = new DatabaseManager();
    }

    @Test
    @DisplayName("Test SceneFactory creates USER scene")
    public void testUserSceneCreation() {
        Stage stage = new Stage();

        Scene scene = SceneFactory.create(SceneType.USER, stage, db);
        assertNotNull(scene);
    }
}