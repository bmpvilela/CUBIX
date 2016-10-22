package org.academiadecodigo.cubix.scoreboard;

/**
 * Created by codecadet on 03/06/16.
 */
public class ScoreBoard {

    private ScoreNumber[] scoreNumber = new ScoreNumber[202];
    private ScoreLevel[] scoreLevel = new ScoreLevel[7];

    /***
     * Creates a board with the level and score number
     */
    public ScoreBoard(){

        for (int i = 0; i < scoreNumber.length; i++){
            scoreNumber[i] = new ScoreNumber(i);
        }

        for (int i = 0; i < scoreLevel.length; i++){
            scoreLevel[i] = new ScoreLevel(i);
        }

        scoreNumber[0].setVisible(true);

    }

    /**
     * Shows the score number by setting invisible the actual score number position
     * and setting visible the new score number position
     *
     * @param score the score number
     */
    public void showPoints(int score){

        if (score > 0 && score < 202) {
            scoreNumber[score - 1].setVisible(false);
            scoreNumber[score].setVisible(true);
        }
    }


    /**
     * Shows the level number by setting invisible the actual level number position
     * and setting visible the new score number position
     *
     * @param level the level number
     */
    public void showLevel(int level){

        if (level > 0 && level < 7) {
            scoreLevel[level - 1].setVisible(false);
            scoreLevel[level].setVisible(true);
        }

        scoreLevel[0].setVisible(true);

    }

}