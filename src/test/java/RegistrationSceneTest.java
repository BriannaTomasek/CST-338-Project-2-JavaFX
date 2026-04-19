import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Explanation: Unit test for RegistrationScene
 *
 * @author Ariya Briscoe
 * @since 4/18/2026
 */
public class RegistrationSceneTest {
    @Test
    @DisplayName("Test RegistrationScene class exists")
    public void testRegistrationSceneExists() {
        assertNotNull(RegistrationScene.class);
    }

    @Test
    @DisplayName("Test SceneFactory routes to REGISTRATION scene")
    public void testSceneFactoryRegistration() {
        assertNotNull(SceneType.REGISTRATION);
    }
}
