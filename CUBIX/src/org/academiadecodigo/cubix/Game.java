package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import org.academiadecodigo.cubix.gameobjects.GameObjects;
import org.academiadecodigo.cubix.gameobjects.GameObjectsFactory;
import org.academiadecodigo.cubix.player.Ball;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;
import org.academiadecodigo.cubix.simplegfx.MazeSgfx;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    public final GameObjects[][] gameLines = new GameObjects[14][]; // TODO array
    private GameObjectsFactory factory;
    private int delay = 200;
    private boolean gameLoop;
    private RepresentableMaze simpleGraphicsMaze;
    private RepresentableBall simpleGraphicsBall;
    private Maze maze;
    private Ball ball;

    public Game(){

        factory = new GameObjectsFactory();

        maze = new Maze();
        simpleGraphicsMaze = new MazeSgfx(maze.getPos().getCol(),maze.getPos().getRow());

        ball = new Ball();
        simpleGraphicsBall = new BallSgfx(ball.getPos().getCol(),ball.getPos().getRow());

        // initBall();

    }

    public void startGame() throws InterruptedException {

        simpleGraphicsMaze.init();
        simpleGraphicsBall.init();
        int count  = 0;

        while (!gameLoop) { // gameLoop a negar propriedade default da gameLoop

            // pause for a while:
            Thread.sleep(delay);

            //create
            if(count == 0){
                create();
                count++;
            }

            // move

        }


    }

    public void create(){
        for(int i = 0; i < gameLines.length; i++){
            gameLines[0] = factory.createCube();
        }
    }

    public void move(){
        // vai mover as nossas cubeLines
    }

    public void crash(){
        // to make a new class
    }

}
