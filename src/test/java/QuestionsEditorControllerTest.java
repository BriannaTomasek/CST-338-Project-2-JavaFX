import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Jessica Sandoval
 * @Description <br>
 * @since 4/23/2026
 */
class QuestionsEditorControllerTest {

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void correctAnswerNotNull() {
    DatabaseManager db = new DatabaseManager();
    QuestionsEditorController questions = new QuestionsEditorController(db);

    boolean result = questions.addQuestion(
        "What is Java?",
        "Not a language",
        "A programming language",
        "A type of disco dance",
    2
    );

    assertTrue(result);
  }

}