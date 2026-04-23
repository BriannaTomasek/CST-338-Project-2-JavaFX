
/**
 * @author Jessica Sandoval
 * @Description <br>
 * @since 4/23/2026
 */
public class QuestionsEditorController {
  // Field Members
  private DatabaseManager db;

  //Constructor generates the database into the class file
  QuestionsEditorController(DatabaseManager db) {
    this.db = db;
  }

  public boolean addQuestion(String question, String answer1,  String answer2, String answer3, Integer correctAnswer) {
    // Make sure all fields have an entry
    if (question.isEmpty() || answer1.isEmpty() || answer2.isEmpty() || answer3.isEmpty()) {
      System.out.println("Error: All fields must be filled!");
      return false;
    }
    // There must be a correct response selected
    if(correctAnswer == null) {
      System.out.println("Error: Correct answer is null!");
      return false;
    }

    // Test that the submit button is working accordingly
    System.out.println("Question: " + question);
    System.out.println("Answer1: " + answer1);
    System.out.println("Answer2: " + answer2);
    System.out.println("Answer3: " + answer3);

    //Add to the database
    return true;
  }

}
