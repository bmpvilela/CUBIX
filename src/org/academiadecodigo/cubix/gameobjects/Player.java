
package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;
import org.academiadecodigo.cubix.RepresentableKeyboard;


/**
 * Created by codecadet on 02/06/16.
 */
public class Player{

    private Ball[] ballLine = new Ball[9];
    private Position pos;
    private RepresentableKeyboard keyboard;

    public Player(RepresentableKeyboard keyboard){

        pos = new Position();
        pos.setCol(4);

        createBallLine();
        ballLine[4].setVisibility(true);

        this.keyboard = keyboard;
    }

    private void createBallLine(){

        for(int i = 0; i< ballLine.length;i++){
            ballLine[i] = new Ball(i);
        }
    }

    public int getCol() {
        return pos.getCol();
    }

    public void moveBall() {

        if(getCol() + keyboard.input() >= 0 && getCol() + keyboard.input() <= 8){
            ballLine[getCol()].setVisibility(false);
            pos.setCol(getCol() + keyboard.input());
            ballLine[getCol()].setVisibility(true);
        }
    }

    public void deleteBall(int col){
        ballLine[col].setVisibility(false);
    }
}
