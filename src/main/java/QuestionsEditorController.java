/**
 * @author Jessica Sandoval
 * @Description <br>
 * @since 4/23/2026
 */
public class QuestionsEditorController {
  // Field Members
  private DatabaseManager db;

  //Constructor generates the database into the class file
  private QuestionsEditorController(DatabaseManager db) {
    this.db = db;
  }

  public void addQuestion(String question) {
    if (question.isEmpty() || question == null) {

    }
  }
}
