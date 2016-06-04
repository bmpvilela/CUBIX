package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;

/**
 * Created by codecadet on 23/05/16.
 */

public class Ball{

    private RepresentableBall simpleGraphicBall;
    private Position pos;
    private boolean isVisible;

    /**
     * Constructs a new ball
     *
     * @param col initial ball position column
     */
    public Ball(int col){

        pos = new Position();
        pos.setCol(col);
        simpleGraphicBall = new BallSgfx(pos.getCol());
    }

    // metodo que torna o cubo visivel ou invisivel (por definição, o cubo esta sempre invisivel)

    /**
     * Sets the visibility of the ball in the screen simply by drawing or deleting is image
     *
     * @param visible the visibility of the ball
     */
    public void setVisibility(boolean visible) {

        isVisible = visible;
        if(isVisible){
            simpleGraphicBall.draw();
        } else{
            simpleGraphicBall.delete();
        }
    }


    //Getters && setters
    public int getCol() {
        return pos.getCol();
    }

    public void setCol(int pos) {
        this.pos.setCol(pos);
    }
}
