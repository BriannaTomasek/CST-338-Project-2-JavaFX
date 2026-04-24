public class UserController {

    private int score;
    private int gamesPlayed;

    public UserController() {
        this.score = 0;
        this.gamesPlayed = 0;
    }

    public String getWelcomeMessage() {
        return "Welcome, User!";
    }

    public int getScore() {
        return score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void updateScore(int newScore) {
        score = newScore;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }
}

