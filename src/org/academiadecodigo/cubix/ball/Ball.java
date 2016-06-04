package org.academiadecodigo.cubix.ball;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableBall;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;

/**
 * Created by codecadet on 23/05/16.
 */

public class Ball{

    private RepresentableBall simpleGraphicBall;
    private Position pos;
    private boolean isVisible;

    public Ball(int col){

        pos = new Position();
        pos.setCol(col);
        simpleGraphicBall = new BallSgfx(pos.getCol());
    }

    public boolean isVisible() {
        return isVisible;
    }

    // metodo que torna o cubo visivel ou invisivel (por definição, o cubo esta sempre invisivel):
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            simpleGraphicBall.draw();
        } else{
            simpleGraphicBall.delete();
        }
    }

    public int getCol() {
        return pos.getCol();
    }

    public void setCol(int pos) {
        this.pos.setCol(pos);
    }
}
