import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author Jessica Sandoval
 * @Description <br>
 * @since 4/22/2026
 */
public class QuestionsEditorScene {

  public static Scene create( Stage stage) {

    //Layout: Window dimensions in pixels
    int SCENE_WIDTH = 600;
    int SCENE_HEIGHT = 500;

    // Prompts and texts
    String QUESTIONS = "Questions: ";
    String QUESTIONS_PROMPT = "Enter java question or code.";
    String OPTION1 = "Option 1: ";
    String OPTION2 = "Option 2: ";
    String OPTION3 = "Option 3: ";
    String OPTION_PROMPT = "Enter optional answer";
    String SUBMIT = "Submit";
    String MAIN_MENU = "Main Menu";

    // Formatting variables (Adjust as needed)
    int SPACING = 50;
    int TEXT_SIZE = 20;
    int BUTTON_SIZE = 20;
    int BUTTON_FONT_SIZE = 20;
    int BUTTON_WIDTH = 20;
    int BUTTON_HEIGHT = 20;
    int BUTTON_SPACING = 20;

    // Text area and fields
    Label questions = new Label(QUESTIONS);
    Label option1 = new Label(OPTION1);
    Label option2 = new Label(OPTION2);
    Label option3 = new Label(OPTION3);
    // Text are for the question being added
    TextArea textArea = new TextArea();
    textArea.setPromptText(QUESTIONS_PROMPT);
    textArea.setEditable(true);
    textArea.setWrapText(true);

    TextField answer1 = new TextField();
    TextField answer2 = new TextField();
    TextField answer3 = new TextField();
    answer1.setPromptText(OPTION_PROMPT);
    answer2.setPromptText(OPTION_PROMPT);
    answer3.setPromptText(OPTION_PROMPT);

    //Buttons

    //Alignment

    // Scene coloring

    // Scene structure
    VBox root = new VBox(questions, textArea,
                        option1, answer1, option2, answer2, option3, answer3);
    Scene questionsEditorScene= new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

    return questionsEditorScene;
  }
}
