import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScene {

    public static Scene create(Stage stage, DatabaseManager db) {

        GameController controller = new GameController(db);

        Label titleLabel = new Label("Game Play Page");
        Label questionNumberLabel = new Label();
        Label questionLabel = new Label();
        Label scoreLabel = new Label("Score: 0");

        Button answer1Button = new Button();
        Button answer2Button = new Button();
        Button answer3Button = new Button();
        Button backButton = new Button("Back to User Page");

        VBox root = new VBox();
        root.setSpacing(25);
        root.setStyle("-fx-background-color: #105461; -fx-padding: 30; -fx-alignment: top-center;");


        root.getChildren().addAll(
                titleLabel,
                questionNumberLabel,
                questionLabel,
                answer1Button,
                answer2Button,
                answer3Button,
                scoreLabel,
                backButton
        );

        Runnable loadQuestion = () -> {
            questionNumberLabel.setText(
                    "Question " + controller.getQuestionNumber() + " of " + controller.getTotalQuestions()
            );

            questionLabel.setText(controller.getCurrentQuestion());

            String[] answers = controller.getCurrentAnswers();
            answer1Button.setText(answers[0]);
            answer2Button.setText(answers[1]);
            answer3Button.setText(answers[2]);

            scoreLabel.setText("Score: " + controller.getScore());
        };

        Runnable endGame = () -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game Over");
            alert.setHeaderText("Trivia Complete!");
            alert.setContentText("Your final score is: " +
                    controller.getScore() + " out of " + controller.getTotalQuestions());
            alert.showAndWait();

            stage.setScene(UserScene.create(stage, db));
        };

        answer1Button.setOnAction(e -> handleAnswer(controller, 0, loadQuestion, endGame));
        answer2Button.setOnAction(e -> handleAnswer(controller, 1, loadQuestion, endGame));
        answer3Button.setOnAction(e -> handleAnswer(controller, 2, loadQuestion, endGame));

        backButton.setOnAction(e ->
                stage.setScene(UserScene.create(stage, db))
        );

        loadQuestion.run();

        titleLabel.setStyle("-fx-font-size: 26; -fx-text-fill: #FFD900; -fx-font-style: italic;");
        questionNumberLabel.setStyle("-fx-font-size: 18; -fx-text-fill: white;");
        questionLabel.setStyle("-fx-font-size: 34; -fx-text-fill: black; -fx-background-color: white; -fx-border-color: #FF4D00; -fx-border-width: 4; -fx-padding: 40; -fx-min-width: 275; -fx-min-height: 220; -fx-alignment: center;");
        scoreLabel.setStyle("-fx-font-size: 20; -fx-text-fill: white;");

        answer1Button.setStyle("-fx-font-size: 20; -fx-padding: 10; -fx-background-color: transparent; -fx-text-fill: white; -fx-min-width: 320; -fx-alignment: center-left; -fx-content-display: left;");
        answer2Button.setStyle("-fx-font-size: 20; -fx-padding: 10; -fx-background-color: transparent; -fx-text-fill: white; -fx-min-width: 320; -fx-alignment: center-left; -fx-content-display: left;");
        answer3Button.setStyle("-fx-font-size: 20; -fx-padding: 10; -fx-background-color: transparent; -fx-text-fill: white; -fx-min-width: 320; -fx-alignment: center-left; -fx-content-display: left;");

        backButton.setText("Main Menu");
        backButton.setStyle("-fx-font-size: 22; -fx-padding: 12; -fx-background-color: #FF4D00; -fx-text-fill: white; -fx-min-width: 300; -fx-border-color: black; -fx-border-width: 2;");

        answer1Button.setGraphic(new javafx.scene.control.RadioButton());
        answer2Button.setGraphic(new javafx.scene.control.RadioButton());
        answer3Button.setGraphic(new javafx.scene.control.RadioButton());


        return new Scene(root, 850, 775);
    }

    private static void handleAnswer(
            GameController controller,
            int selectedAnswer,
            Runnable loadQuestion,
            Runnable endGame
    ) {
        boolean isCorrect = controller.checkAnswer(selectedAnswer);

        if (isCorrect) {
            Alert correctAlert = new Alert(Alert.AlertType.INFORMATION);
            correctAlert.setTitle("Correct!");
            correctAlert.setHeaderText("Nice job!");
            correctAlert.setContentText("You got the answer correct.");

            correctAlert.setX(520);   // move left/right
            correctAlert.setY(420);   // move down over choices

            correctAlert.showAndWait();
        }

        if (controller.hasNextQuestion()) {
            controller.moveToNextQuestion();
            loadQuestion.run();
        } else {
            endGame.run();
        }
    }
}


