package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.simplegfx.ScoreNumberSgfx;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreNumber {

    private RepresentableScoreNumber sGraphicScoreNumber;
    private boolean isVisible;

    public ScoreNumber(int score){

        sGraphicScoreNumber = new ScoreNumberSgfx(score);
    }

    public boolean isVisible() {
        return isVisible;
    }

    // metodo que torna o cubo visivel ou invisivel (por definição, o cubo esta sempre invisivel):
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            sGraphicScoreNumber.draw();
        } else{
            sGraphicScoreNumber.delete();
        }
    }

}
