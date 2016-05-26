package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableBall;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class BallSgfx implements RepresentableBall {
    private int col;
    private int row;

    public BallSgfx(int col, int row){
        this.col = col;
        this.row = row;
    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public int getRow() {
        return 0;
    }

    @Override
    public void init() {
        Picture pic = new Picture("TEMPLATES/Board_Cubes/Ball.png");
        pic.draw();
    }
}

