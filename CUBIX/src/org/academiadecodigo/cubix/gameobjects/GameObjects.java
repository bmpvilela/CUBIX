package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public class GameObjects {

    private Position pos;
    private boolean isVisible; // default >> false


    public GameObjects(){

        isVisible = true; // all the cubes are visible

        pos = new Position(); // the position is already 0,0 because the properties from the position are int (0 by default)

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
