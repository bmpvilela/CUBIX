package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableCube;
import org.academiadecodigo.cubix.simplegfx.CubeSgfx;

/**
 * Created by codecadet on 23/05/16.
 */

public class Cube {

    private Position pos;
    private boolean isVisible;
    private RepresentableCube simpleGraphicsCube;

    public Cube(int row, int col){

        pos = new Position();
        pos.setRow(row);
        pos.setCol(col);
        simpleGraphicsCube = new CubeSgfx(row, col);
    }

    public boolean isVisible() {
        return isVisible;
    }

    // metodo que torna o cubo visivel ou invisivel (por definição, o cubo esta sempre invisivel):
    public void setVisible(boolean visible) {

        isVisible = visible;
        if(isVisible){
            simpleGraphicsCube.draw();
        } else{
            simpleGraphicsCube.delete();
        }

    }
}
