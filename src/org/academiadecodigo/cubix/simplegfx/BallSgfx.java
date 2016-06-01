package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableBall;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class BallSgfx implements RepresentableBall {

    private Picture pic;

    public BallSgfx(int col){
        pic = new Picture("TEMPLATES/Ball/" + col + ".png");
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

