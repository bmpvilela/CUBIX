package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableMenu;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 03/06/16.
 */
public class MenuSgfx implements RepresentableMenu {

    private Picture pic;
    private Picture gameOver;

    @Override
    public void deleteGameOver() {
        gameOver.delete();
    }

    @Override
    public void drawGameOver() {
        gameOver = new Picture("TEMPLATES/GameOver.png");
        gameOver.draw();
    }

    @Override
    public void delete() {
        pic.delete();
    }

    @Override
    public void draw() {
        pic = new Picture("TEMPLATES/Menu.png");
        pic.draw();
    }
}
