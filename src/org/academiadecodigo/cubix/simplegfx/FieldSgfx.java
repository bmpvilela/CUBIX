package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableField;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class FieldSgfx implements RepresentableField {

    @Override
    public void init() {
        Picture pic = new Picture(0, 0, "art/Board.png");
        pic.draw();

    }
}
