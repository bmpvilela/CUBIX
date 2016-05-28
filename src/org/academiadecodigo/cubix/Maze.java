package org.academiadecodigo.cubix;

/**
 * Created by codecadet on 24/05/16.
 */

public class Maze {
    private RepresentableMaze repr;
    private Position pos;

    public Maze(){
        pos = new Position();
    }

    public void setRepr(RepresentableMaze repr) {
        this.repr = repr;
    }

    public RepresentableMaze getRepr() {
        return repr;
    }

    public Position getPos() {
        return pos;
    }
}
