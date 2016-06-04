package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.simplegfx.MenuSgfx;

/**
 * Created by codecadet on 03/06/16.
 */
public class Menu {

    private RepresentableMenu sGraphicsMenu;
    private RepresentableKeyboard keyboard;

    // metodo construtor do Menu
    public Menu(RepresentableKeyboard keyboard) throws InterruptedException {

        this.keyboard = keyboard;
        sGraphicsMenu = new MenuSgfx(); // instancia o simplegraphics do startscreen
    }

    public void optionMenu() throws InterruptedException {

        sGraphicsMenu.drawMenu();

        while(keyboard.input() != 32){
            Thread.sleep(100);
            //decision
        }

        sGraphicsMenu.deleteMenu();
    }

    public void gameOver() throws InterruptedException {

        sGraphicsMenu.drawGameOver();
        Thread.sleep(3000);
        sGraphicsMenu.deleteGameOver();
    }

}