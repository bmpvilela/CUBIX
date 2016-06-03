package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.simplegfx.KeyboardSgfx;
import org.academiadecodigo.cubix.simplegfx.MenuSgfx;

/**
 * Created by codecadet on 03/06/16.
 */
public class Menu {

    private RepresentableMenu simpleGraphicsStartMenu;
    private RepresentableKeyboard keyboard;




    // metodo construtor do Menu
    public Menu(RepresentableKeyboard keyboard) throws InterruptedException {
        //keyboard = new KeyboardSgfx();

        this.keyboard = keyboard;
        simpleGraphicsStartMenu = new MenuSgfx(); // instancia o simplegraphics do startscreen
    }

    public void optionMenu() throws InterruptedException {

        simpleGraphicsStartMenu.draw();

        while(keyboard.input() != 32){
            Thread.sleep(100);
            //decision
        }

        simpleGraphicsStartMenu.delete();

        System.out.println("init game");
    }

    public void gameOver() throws InterruptedException {

        simpleGraphicsStartMenu.drawGameOver();

        Thread.sleep(3000);

        simpleGraphicsStartMenu.deleteGameOver();
    }

}
