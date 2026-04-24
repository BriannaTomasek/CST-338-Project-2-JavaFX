import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class UserToGameUITest extends ApplicationTest {

    private DatabaseManager db;

    @Override
    public void start(Stage stage) {
        db = new DatabaseManager();

        Scene scene = UserScene.create(stage, db);
        stage.setScene(scene);
        stage.show();
    }
}
