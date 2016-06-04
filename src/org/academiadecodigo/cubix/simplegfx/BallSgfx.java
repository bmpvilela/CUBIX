package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.gameobjects.RepresentableBall;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class BallSgfx implements RepresentableBall {

    private Picture pic;


    /**
     * Creates the graphic representation of the ball
     *
     * @param col initial ball position
     */
    public BallSgfx(int col){
        pic = new Picture("TEMPLATES/ball/" + col + ".png");
    }


    @Override
    public void draw() {
        pic.draw();
    }

    @Override
    public void delete() {
        pic.delete();
    }
}

