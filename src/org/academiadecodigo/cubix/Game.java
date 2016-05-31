package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.GameObjectFactory;
import org.academiadecodigo.cubix.gameobjects.GameObjects;
import org.academiadecodigo.cubix.gameobjects.GameObjectsLines;
import org.academiadecodigo.cubix.player.Ball;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;
import org.academiadecodigo.cubix.simplegfx.MazeSgfx;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    private GameObjectsLines[] gameObjects = new GameObjectsLines[14]; // TODO change the game objects
    private final int delay = 100; //TODO add two counters for different delays (lines and ball)
    private boolean gameLoop;

    private RepresentableMaze simpleGraphicsMaze;
    private RepresentableBall simpleGraphicsBall;

    private Maze maze;
    private Ball ball;

    private GameObjectFactory factory;
    private int gameLevel = 2;
    private int linesCounter = 1;
    private int trigger = gameObjects.length/gameLevel;

    public Game(){

        maze = new Maze();
        simpleGraphicsMaze = new MazeSgfx(maze.getPos().getCol(),maze.getPos().getRow());

        ball = new Ball();
        simpleGraphicsBall = new BallSgfx(ball.getPos().getCol(),ball.getPos().getRow());

        factory = new GameObjectFactory();

    }

    public void startGame() throws InterruptedException {

        simpleGraphicsMaze.init();
        simpleGraphicsBall.init();

        gameObjects[0] = factory.createGameObject(gameLevel);

        while (!gameLoop) { // gameLoop a negar propriedade default da gameLoop

            // pause for a while:
            Thread.sleep(delay);

            //create line //TODO Define a max level (maybe 7)
            /**
             * The trigger position is the board length divided by the game level
             * ex: level 1 trigger is 14 (14/1). New line appears when the cube line arrives the last line (14)
             *     level 2 trigger is 7 (17/2). New line appears when the cube line arrives the line 7 and 14.
             *     (...)
             * So, if the module of the line position with trigger is 0 we create a new line.
             * The trigger defines the delta between each new line.
             */
            trigger = gameObjects.length/gameLevel;

            create();

            // move
            moveLine();
        }
    }

    public void create(){

        /**
         * create a max of 7 lines (board lenght/2).
         * This gives a board fill with a line with cubes fallowed by a clean line
         */

        if (linesCounter < gameLevel){
            if(gameObjects[0].getPos().getRow()%trigger==0 && gameObjects[0].getPos().getRow()!=0){
                gameObjects[linesCounter] = factory.createGameObject(gameLevel);
                linesCounter++;
            }
        }

    }

    public void moveLine(){

        for(int i = 0; i < linesCounter; i++){

            if (gameObjects[i].getPos().getRow() < gameObjects.length - 1) {
                gameObjects[i].move();
            } else {
                //colision();
                System.out.println(gameObjects[i].getCubeStatus(ball.getPos().getCol())); //Request status (visible or not) from the cube with same col of the bal (if visible -> colision)
                gameObjects[i].deleteLine();
                gameObjects[i] = factory.createGameObject(gameLevel); //TODO pass gameLevel for move. dont make sense
            }

        }
    }
}
