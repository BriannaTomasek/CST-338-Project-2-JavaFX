/**
 * This class creates and edits the Results scene.
 * @author Vincent Marinello-Sweeney
 * created 4/22/26
 * @since 4/22/26
 * @version 1.0 */

//package PACKAGE_NAME;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Results {
    //VBox root = new VBox(15);
    //VBox root = new VBox(15);
    //VBox root = new VBox(15);

    //Scene scene = new Scene(root);

    /**
     * Creates the Results scene
     * @param stage
     * @return the scene
     */
    public static Scene create(Stage stage){
        //Window dimensions in pixels
        final int SCENE_WIDTH = 800;
        final int SCENE_HEIGHT = 600;
        int todaysBestNumerator = 5; // for now
        int overallHighestNumerator = 7;
        int numberOfTotalPlays = 15;
        final int numberOfQuestions = 5;
        final String RESULTS_LABEL = "Results";
        final String USERNAME_LABEL = "Username Scores:  ";
        final String TODAYS_BEST_LABEL = "Today's Best:  ";
        final String OVERALL_HIGHEST_LABEL = "Overall Highest:  ";
        final String TOTAL_PLAYS_LABEL = "Total Plays:  ";
        final String MAIN_MENU_BUTTON = "MAIN MENU";

        String TODAYS_BEST_LABEL2 = todaysBestNumerator + "/" + numberOfQuestions;
        String OVERALL_HIGHEST_LABEL2 = overallHighestNumerator + "/" + numberOfQuestions;
        String TOTAL_PLAYS_LABEL2 = String.valueOf(numberOfTotalPlays);

        Label usernameScoresLabel = new Label(USERNAME_LABEL);
        Label todaysBestLabel = new Label(TODAYS_BEST_LABEL);
        Label overallHighestLabel = new Label(OVERALL_HIGHEST_LABEL);
        Label totalPlaysLabel = new Label(TOTAL_PLAYS_LABEL);
        Label todaysBestLabel2 = new Label(TODAYS_BEST_LABEL2);
        Label overallHighestLabel2 = new Label(OVERALL_HIGHEST_LABEL2);
        Label totalPlaysLabel2 = new Label(TOTAL_PLAYS_LABEL2);

        Button mainMenuButton = new Button(MAIN_MENU_BUTTON);

        VBox resultsRoot1 = new VBox(15, usernameScoresLabel,  todaysBestLabel, overallHighestLabel, totalPlaysLabel, todaysBestLabel2, overallHighestLabel2, totalPlaysLabel2);
        resultsRoot1.setPadding(new Insets(30));
        resultsRoot1.setAlignment(Pos.CENTER_LEFT);

        VBox mainMenuButtonVBox = new VBox(20, mainMenuButton);
        mainMenuButtonVBox.setPadding(new Insets(30));
        mainMenuButtonVBox.setAlignment(Pos.CENTER);

        VBox everything = new VBox(20, resultsRoot1, mainMenuButtonVBox);

        Scene scene = new Scene(everything, SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle(RESULTS_LABEL);
        stage.setScene(scene);
        return scene;
    }


}
