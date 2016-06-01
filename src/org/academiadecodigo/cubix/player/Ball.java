package org.academiadecodigo.cubix.player;

import com.sun.xml.internal.bind.v2.TODO;
import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableBall;
import org.academiadecodigo.cubix.RepresentableField;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;

/**
 * Created by codecadet on 23/05/16.
 */

public class Ball{

    private RepresentableBall simpleGraphicBall;
    private Position pos;
    private Ball[] ballArray = new Ball[9];

    public Ball(){

        pos = new Position();
        pos.setCol(4);
        simpleGraphicBall = new BallSgfx(pos.getCol());
    }

    //TODO this create ball need to be a new class that has an array of all balls and then it controls what ball is displyed in the screen
    /*
    private void createBalls(){
        for(int i = 0; i < ballArray.length; i++){
        }
    }*/

    public int getCol() {
        return pos.getCol();
    }

    // keyboard


}
