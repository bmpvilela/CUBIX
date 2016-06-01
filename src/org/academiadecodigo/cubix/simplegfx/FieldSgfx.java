package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableField;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 23/05/16.
 */
public class FieldSgfx implements RepresentableField {

    // display do nosso Field, recebe uma imagem (neste caso o board) e desenha-o:
    @Override
    public void init() {
        Picture pic = new Picture("TEMPLATES/Board.png");
        pic.draw();
    }
}
