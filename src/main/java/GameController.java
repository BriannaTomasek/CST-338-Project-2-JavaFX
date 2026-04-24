

public class GameController {

    private int currentQuestionIndex = 0;
    private int score = 0;

    private final String[] questions = {
            "What is JavaFX used for?",
            "Which keyword creates a class in Java?",
            "Which symbol ends most Java statements?"
    };

    private final String[][] answers = {
            {"Databases only", "GUI applications", "Operating systems"},
            {"method", "class", "object"},
            {".", ";", ":"}
    };

    private final int[] correctAnswers = {1, 1, 1};

    public GameController(DatabaseManager db) {

    }

    public String getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public String[] getCurrentAnswers() {
        return answers[currentQuestionIndex];
    }

    public boolean checkAnswer(int selectedAnswer) {
        boolean correct = selectedAnswer == correctAnswers[currentQuestionIndex];

        if (correct) {
            score++;
        }

        return correct;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.length - 1;
    }

    public void moveToNextQuestion() {
        if (hasNextQuestion()) {
            currentQuestionIndex++;
        }
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return questions.length;
    }

    public int getQuestionNumber() {
        return currentQuestionIndex + 1;
    }
}


