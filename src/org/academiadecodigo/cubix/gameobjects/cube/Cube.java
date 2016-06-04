package org.academiadecodigo.cubix.gameobjects.cube;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.simplegfx.CubeSgfx;

/**
 * Created by codecadet on 23/05/16.
 */

public class Cube {

    private Position pos;
    private boolean isVisible;
    private RepresentableCube simpleGraphicsCube;

    /**
     * Constructs a new cube
     *
     * @param row initial cube position row
     * @param col initial cube position column
     */
    public Cube(int row, int col){

        pos = new Position();
        pos.setRow(row);
        pos.setCol(col);
        simpleGraphicsCube = new CubeSgfx(row, col);
    }


    /**
     * Sets the visibility of the cube in the screen simply by drawing or deleting is image
     *
     * @param visible the visibility of the ball
     */
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            simpleGraphicsCube.draw();
        } else{
            simpleGraphicsCube.delete();
        }

    }
}
