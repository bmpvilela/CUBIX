package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableCube;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class CubeSgfx implements RepresentableCube {

    private Picture pic;

    public CubeSgfx(int row, int col){
        pic = new Picture("TEMPLATES/" + row + "/" + col + ".png");
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
