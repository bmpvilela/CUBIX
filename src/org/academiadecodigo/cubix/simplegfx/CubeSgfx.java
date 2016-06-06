package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.gameobjects.cube.RepresentableCube;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class CubeSgfx implements RepresentableCube {

    private Picture pic;


    /**
     * Creates the graphic representation of the cube
     *
     * @param row the cube row position
     * @param col the cube column position
     */
    public CubeSgfx(int row, int col) {
        pic = new Picture(0, 0, "art/" + row + "/" + col + ".png");
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
