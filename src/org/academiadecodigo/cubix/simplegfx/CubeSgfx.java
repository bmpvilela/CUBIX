package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.gameobjects.cube.RepresentableCube;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class CubeSgfx implements RepresentableCube {

    private Picture pic;


    /**
     * Creates the graphic representation of the cube
     *
     * @param row initial cube position row
     * @param col initial cube position column
     */
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
