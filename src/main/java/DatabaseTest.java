import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    String sqlQueryTest0 =
            "SELECT * FROM user WHERE userID == user.userID";

    String sqlQueryTest1 =
            "SELECT * FROM user WHERE username == user.username";

    String sqlQueryTest2 =
            "SELECT * FROM user WHERE emailAddress == user.emailAddress";

    String sqlQueryTest3 =
            "SELECT * FROM user WHERE password == user.password";

}
