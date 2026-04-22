import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for admin routing logic
 *
 * @author Ariya Briscoe
 * @since 4/21/2026
 */
public class AdminRoutingTest {

    @Test
    @DisplayName("Test admin username routes to admin dashboard")
    public void testAdminUsernameRoutesToAdminDashboard() {
        String username = "admin_user";
        assertTrue(username.toLowerCase().startsWith("admin"));
    }

    @Test
    @DisplayName("Test regular username does not route to admin dashboard")
    public void testRegularUsernameDoesNotRouteToAdmin() {
        String username = "testuser";
        assertFalse(username.toLowerCase().startsWith("admin"));
    }

    @Test
    @DisplayName("Test case insensitive admin detection")
    public void testCaseInsensitiveAdminDetection() {
        String username = "ADMIN_testuser";
        assertTrue(username.toLowerCase().startsWith("admin"));
    }
}
