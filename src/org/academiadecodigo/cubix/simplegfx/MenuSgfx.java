package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.menu.RepresentableMenu;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 03/06/16.
 */
public class MenuSgfx implements RepresentableMenu {

    private Picture picMenu;
    private Picture picGameOver;

    @Override
    public void deleteGameOver() {
        picGameOver.delete();
    }

    @Override
    public void drawGameOver() {

        picGameOver = new Picture("art/GameOver.png");
        picGameOver.draw();
    }

    @Override
    public void deleteMenu() {
        picMenu.delete();
    }

    @Override
    public void drawMenu() {

        picMenu = new Picture("art/SpaceToStart.png");
        picMenu.draw();
    }
}
