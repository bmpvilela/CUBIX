package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableCube;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class CubeSgfx implements RepresentableCube {
    private int col;
    private int row;
    private Picture pic;

    public CubeSgfx(int col, int row){
        this.col = col;
        this.row = row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public void init() {

            pic = new Picture("TEMPLATES/Board_Cubes/" + row + "/" + "(" + (col + 1) + ")" + ".png"); //
            pic.draw();
    }

    @Override
    public void load(int col, int row) {

            this.col = col;
            this.row = row;
            pic.load("TEMPLATES/Board_Cubes/" + this.row + "/" + "(" + (this.col + 1) + ")" + ".png");
    }

    @Override
    public void delete() {
        pic.delete();
    }
}
