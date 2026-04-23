import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    int SCENE_HEIGHT = 650;

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
    int SPACING = 5;
    int TEXT_SIZE = 20;
    int BUTTON_FONT_SIZE = 20;
    int BUTTON_WIDTH = 200;
    int BUTTON_HEIGHT = 50;
    int BUTTON_SPACING = 5;

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
    Button submit = new Button(SUBMIT);
    Button mainMenu = new Button(MAIN_MENU);

    //Alignment
    textArea.setMaxWidth(550);
    answer1.setMaxWidth(550);
    answer2.setMaxWidth(550);
    answer3.setMaxWidth(550);

    VBox buttonBox = new VBox();
    buttonBox.setSpacing(BUTTON_SPACING);
    buttonBox.setAlignment(Pos.BASELINE_CENTER);
    buttonBox.getChildren().addAll(submit, mainMenu);

    submit.setMaxWidth(BUTTON_WIDTH);
    mainMenu.setMinHeight(BUTTON_HEIGHT);
    mainMenu.setMaxWidth(BUTTON_WIDTH);
    mainMenu.setFont(Font.font(BUTTON_FONT_SIZE));

    Region spacer = new Region();
    Region spacer2 = new Region();
    Region spacer3 = new Region();
    VBox.setVgrow(spacer, Priority.ALWAYS);
    VBox.setVgrow(spacer2, Priority.ALWAYS);
    VBox.setVgrow(spacer3, Priority.ALWAYS);

    // Coloring and effects
    DropShadow buttonShadow = new DropShadow();
    textArea.setStyle("-fx-border-color: #000000;" +
                      "-fx-border-width: 2px;");
    textArea.setEffect(buttonShadow);

    answer1.setStyle("-fx-border-color: #000000;" +
        "-fx-border-width: 2px;");
    answer1.setEffect(buttonShadow);

    answer2.setStyle("-fx-border-color: #000000;" +
        "-fx-border-width: 2px;");
    answer2.setEffect(buttonShadow);

    answer3.setStyle("-fx-border-color: #000000;" +
        "-fx-border-width: 2px;");
    answer3.setEffect(buttonShadow);

    submit.setStyle("-fx-background-color: #FF4000;" +
                      "-fx-border-color: #000000;" +
                      "-fx-border-width: 2px;" +
                      "-fx-background-insets: 0;");
    submit.setEffect(buttonShadow);
    submit.setTextFill(Color.WHITE);

    mainMenu.setStyle("-fx-background-color: #FF4000;" +
                      "-fx-border-color: #000000;" +
                      "-fx-border-width: 2px;" +
                      "-fx-background-insets: 0;");
    mainMenu.setEffect(buttonShadow);
    mainMenu.setTextFill(Color.WHITE);

    // Scene structure
    VBox root = new VBox(SPACING);
    root.setStyle("-fx-background-color: #1A5064;");
    root.setAlignment(Pos.CENTER);
    root.getChildren().addAll(spacer, questions, textArea, spacer2,
                        option1, answer1, option2, answer2, option3, answer3,
                        buttonBox, spacer3);


    Scene questionsEditorScene= new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);

    return questionsEditorScene;
  }
}
