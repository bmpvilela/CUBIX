package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableKeyboard;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 02/06/16.
 */
public class KeyboardSgfx implements KeyboardHandler,RepresentableKeyboard{

    private Keyboard keyboard;
    private int numb = 0;

    public KeyboardSgfx(){
        keyboard = new Keyboard(this);
        createEvent(KeyboardEvent.KEY_LEFT);
        createEvent(KeyboardEvent.KEY_RIGHT);
        createReleaseEvent(KeyboardEvent.KEY_LEFT);
        createReleaseEvent(KeyboardEvent.KEY_RIGHT);
    }

    private void createEvent(int key){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);
    }

    private void createReleaseEvent(int key){
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);
    }

    @Override
    public int input() {
        return numb;
    }

    @Override
    public void keyPressed(KeyboardEvent e) {
        switch (e.getKey()){
            case KeyboardEvent.KEY_LEFT:
                numb = -1;
                break;

            case KeyboardEvent.KEY_RIGHT:
                numb = 1;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent e) {
        numb = 0;
    }
}