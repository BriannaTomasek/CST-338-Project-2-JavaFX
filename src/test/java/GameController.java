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
    public String getCurrentQuestion() {
        return questions[currentQuestionIndex];
    }

    public String[] getCurrentAnswers() {
        return answers[currentQuestionIndex];
    }

    public int getTotalQuestions() {
        return questions.length;
    }

    public int getQuestionNumber() {
        return currentQuestionIndex + 1;
    }
}

