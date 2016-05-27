package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.GameObjectFactory;
import org.academiadecodigo.cubix.gameobjects.GameObjects;
import org.academiadecodigo.cubix.gameobjects.GameObjectsLines;
import org.academiadecodigo.cubix.player.Ball;
import org.academiadecodigo.cubix.simplegfx.BallSgfx;
import org.academiadecodigo.cubix.simplegfx.MazeSgfx;

/**
 * Created by codecadet on 23/05/16.
 */
public class Game {

    public GameObjectsLines[] gameObjects = new GameObjectsLines[14]; // TODO change the game objects
    private int delay = 200;
    private boolean gameLoop;
    private RepresentableMaze simpleGraphicsMaze;
    private RepresentableBall simpleGraphicsBall;
    private Maze maze;
    private Ball ball;
    private GameObjectFactory factory;

    public Game(){

        maze = new Maze();
        simpleGraphicsMaze = new MazeSgfx(maze.getPos().getCol(),maze.getPos().getRow());

        ball = new Ball();
        simpleGraphicsBall = new BallSgfx(ball.getPos().getCol(),ball.getPos().getRow());

        factory = new GameObjectFactory();
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
            moveLine();

        }


    }

    public void create(){
        for(int i = 0; i < 1; i++){
            gameObjects[i] = factory.createGameObject();
        }
    }

    public void moveLine(){
        for(int i = 0; i < 1; i++){
            if(gameObjects[i].getPos().getRow() < gameObjects.length - 1) {
                gameObjects[i].move();
            } else {
                gameObjects[i].deleteLine();
                gameObjects[i] = factory.createGameObject();
            }

        }
    }

    public void crash(){
        // to make a new class
    }
}
