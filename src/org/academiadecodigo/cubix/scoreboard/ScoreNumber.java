package org.academiadecodigo.cubix.scoreboard;

import org.academiadecodigo.cubix.simplegfx.ScoreNumberSgfx;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreNumber {

    private RepresentableScoreNumber sGraphicScoreNumber;
    private boolean isVisible;

    /**
     * Creates a new graphic representation of the score number
     *
     * @param score the score number
     */

    public ScoreNumber(int score){

        sGraphicScoreNumber = new ScoreNumberSgfx(score);
    }


    /**
     * Sets the visibility of the score number in the screen simply by drawing or deleting is image
     *
     * @param visible the visibility of the score number
     */
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            sGraphicScoreNumber.draw();
        } else{
            sGraphicScoreNumber.delete();
        }
    }


    //Getters and setters
    public boolean isVisible() {
        return isVisible;
    }



}
