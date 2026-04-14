import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Explanation: Unit test for SceneFactory
 *
 * @author Ariya Briscoe
 * @since 4/13/2026
 */
public class SceneFactoryTest {

  // Test for LOGIN scene exists
  @Test
  @DisplayName("Test LOGIN scene type exists")
  public void testLoginSceneType() {
    assertNotNull(SceneType.LOGIN);
  }

  // Test for REGISTRATION scene exists
  @Test
  @DisplayName("Test REGISTRATION scene type exists")
  public void testRegistrationSceneType() {
    assertNotNull(SceneType.REGISTRATION);
  }
}
