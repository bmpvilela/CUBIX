package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import org.academiadecodigo.cubix.player.Ball;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    private Maze maze;
    private Ball ball;
    public final Cube[] cubeLines = new Cube[14]; // TODO array
    private int delay = 200;
    private boolean gameLoop;


    public Game(){

        // initMaze();

        // initBall();

    }

    public void startGame() throws InterruptedException {

        while (!gameLoop) { // gameLoop a negar propriedade default da gameLoop

            // pause for a while:
            Thread.sleep(delay);

            // delay

            // move

        }


    }

    public void move(){
        // vai mover as nossas cubeLines
    }

    public void crash(){
        // to make a new class
    }

}
