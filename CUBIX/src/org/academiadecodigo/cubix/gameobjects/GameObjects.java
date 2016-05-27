package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableCube;
import org.academiadecodigo.cubix.simplegfx.CubeSgfx;

/**
 * Created by codecadet on 23/05/16.
 */
public class GameObjects {

    private Position pos;
    private boolean isVisible; // default >> false
    private RepresentableCube simpleGraphicsCube;


    public GameObjects(int col){

        isVisible = true; // all the cubes are visible

        pos = new Position(); // the position is already 0,0 because the properties from the position are int (0 by default)

        pos.setCol(col);

        simpleGraphicsCube = new CubeSgfx(getPos().getCol(),getPos().getRow());
        simpleGraphicsCube.init();

    }

    public void move(){
        pos.setRow(pos.getRow()+1);
        simpleGraphicsCube.load(getPos().getCol(),getPos().getRow());
    }

    // GETTERS && SETTERS

    public Position getPos() {
        return pos;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }



}
