
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

    /**
     * Creates a new player and set the current Player ball
     * in the middle of the field
     *
     * @param keyboard the player's keyboard
     */
    public Player(RepresentableKeyboard keyboard){

        pos = new Position();
        pos.setCol(4);

        createBallLine();
        ballLine[4].setVisibility(true);

        this.keyboard = keyboard;
    }


    /**
     * Creates a new ball for each position of the ball line
     */
    private void createBallLine(){

        for(int i = 0; i< ballLine.length;i++){
            ballLine[i] = new Ball(i);
        }
    }

    /**
     * Gets the player ball column position
     *
     * @return the player ball column position
     */
    public int getCol() {
        return pos.getCol();
    }

    /**
     * Moves the ball along the ball line by setting invisible the actual ball position
     * and setting visible the new ball position
     *
     * The ball will move to the left if the keyboard input is -1
     * and to the right if is 1.
     */
    public void moveBall() {

        if(getCol() + keyboard.input() >= 0 && getCol() + keyboard.input() <= 8){
            ballLine[getCol()].setVisibility(false);
            pos.setCol(getCol() + keyboard.input());
            ballLine[getCol()].setVisibility(true);
        }
    }

    /**
     * Hide the ball by setting is position invisible
     *
     * @param col the ball column position
     */
    public void deleteBall(int col){
        ballLine[col].setVisibility(false);
    }
}
