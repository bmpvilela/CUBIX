package org.academiadecodigo.cubix.player;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableField;

/**
 * Created by codecadet on 23/05/16.
 */

public class Ball{

    private RepresentableField repr;
    private Position pos;

    public Ball(){

        pos = new Position();
        pos.setCol(4);
        pos.setRow(13);

    }

    public void setRepr(RepresentableField repr) {
        this.repr = repr;
    }

    public RepresentableField getRepr() {
        return repr;
    }

    public Position getPos() {
        return pos;
    }

    // keyboard


}
