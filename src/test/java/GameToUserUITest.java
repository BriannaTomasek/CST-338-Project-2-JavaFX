import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class GameToUserUITest extends ApplicationTest {

    private DatabaseManager db;
    @Override
    public void start(Stage stage) {
        db = new DatabaseManager();

        Scene scene = GameScene.create(stage, db);
        stage.setScene(scene);
        stage.show();
    }
    @Test
    public void testGameSceneToUserSceneTransition() {
        clickOn("Back to User Page");

        verifyThat("User Scene", hasText("User Scene"));
    }
}
