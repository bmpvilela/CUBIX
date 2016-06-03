package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.ball.Ball;
import org.academiadecodigo.cubix.simplegfx.KeyboardSgfx;

/**
 * Created by codecadet on 02/06/16.
 */
public class Player{

    private Ball[] ballLine = new Ball[9];
    private Position pos;
    private RepresentableKeyboard keyboard;

    public Player(){

        pos = new Position();
        pos.setCol(4);

        createBallLine();
        ballLine[4].setVisible(true);

        keyboard = new KeyboardSgfx();
    }

    private void createBallLine(){
        for(int i = 0; i< ballLine.length;i++){
            ballLine[i] = new Ball(i);
            System.out.println("Ball col: " + ballLine[i].getCol());
        }
    }

    public int getCol() {
        return pos.getCol();
    }

    public void moveBall() {
        if(getCol() + keyboard.input() >= 0 && getCol() + keyboard.input() <= 8){
            ballLine[getCol()].setVisible(false);
            pos.setCol(getCol() + keyboard.input());
            ballLine[getCol()].setVisible(true);
        }
    }

    public void deleteBall(int col){
        ballLine[col].setVisible(false);
    }
}
