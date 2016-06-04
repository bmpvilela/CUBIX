package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.simplegfx.ScoreLevelSgfx;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreLevel {

    private RepresentableScoreLevel sGraphicScoreLevel;
    private boolean isVisible;

    public ScoreLevel(int level){

        sGraphicScoreLevel = new ScoreLevelSgfx(level);

    }

    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            sGraphicScoreLevel.draw();
        } else{
            sGraphicScoreLevel.delete();
        }
    }

}