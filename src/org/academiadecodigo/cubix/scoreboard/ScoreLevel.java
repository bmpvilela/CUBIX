package org.academiadecodigo.cubix.scoreboard;

import org.academiadecodigo.cubix.simplegfx.ScoreLevelSgfx;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreLevel {

    private RepresentableScoreLevel sGraphicScoreLevel;
    private boolean isVisible;

    /**
     * Creates a new graphic representation of the level number
     *
     * @param level the level number
     */

    public ScoreLevel(int level){

        sGraphicScoreLevel = new ScoreLevelSgfx(level);
    }

    /**
     * Sets the visibility of the level number in the screen
     * simply by drawing or deleting is image
     *
     * @param visible the visibility of the level number
     */
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            sGraphicScoreLevel.draw();
        } else{
            sGraphicScoreLevel.delete();
        }
    }
}