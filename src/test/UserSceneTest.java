import static org.junit.jupiter.api.Assertions.assertNotNull;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserSceneTest

  @Test
  @DisplayName("Test SceneFactory creates USER scene")
  public void testSceneFactoryUser() {
  public void testUserSceneExists() {
    Stage stage = new Stage();
    Scene scene = SceneFactory.create(SceneType.USER, stage);
    assertNotNull(scene);
  }
}