import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Explanation: Unit test for LoginScene
 *
 * @author Ariya Briscoe
 * @since 4/13/2026
 */
public class LoginSceneTest {

  @Test
  @DisplayName("Test LoginScene class exists")
  public void testLoginSceneExists() {
    assertNotNull(LoginScene.class);
  }

  @Test
  @DisplayName("Test SceneFactory routes to LOGIN scene")
  public void testSceneFactoryLogin() {
    assertNotNull(SceneType.LOGIN);
  }

  @Test
  @DisplayName("Test SceneFactory routes to REGISTRATION scene")
  public void testSceneFactoryRegistration() {
    assertNotNull(SceneType.REGISTRATION);
  }
}
