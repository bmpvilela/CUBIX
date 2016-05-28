package org.academiadecodigo.cubix.player;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableMaze;

/**
 * Created by codecadet on 23/05/16.
 */

public class Ball{

    private RepresentableMaze repr;
    private Position pos;

    public Ball(){

        pos = new Position();
        pos.setCol(3);
        pos.setRow(7);

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

    // keyboard


}
