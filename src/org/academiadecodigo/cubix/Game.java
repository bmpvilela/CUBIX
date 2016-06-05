package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Line;
import org.academiadecodigo.cubix.gameobjects.Player;
import org.academiadecodigo.cubix.gameobjects.cube.Cube;
import org.academiadecodigo.cubix.menu.Menu;
import org.academiadecodigo.cubix.scoreboard.ScoreBoard;
import org.academiadecodigo.cubix.simplegfx.KeyboardSgfx;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */

public class Game {

    private Menu menu;

    private LinkedList<Line> lineList;
    private int delay = 5;
    private boolean gameLoop;
    private long time;

    private Field board;
    private Player player;
    private ScoreBoard scoreboard;

    private int numberOfHoles = 1;
    private int newLineCounter;
    private int trigger = 15; //number of loops to create a new line
    private int levelCounter;
    private int level = 1;
    private int score;

    private RepresentableKeyboard keyboard;
    private boolean pauseControl;


    /**
     * Creates a new game
     *
     * @throws InterruptedException
     */
    public Game() throws InterruptedException {

        keyboard = new KeyboardSgfx();
        menu = new Menu(keyboard);

        init();
    }

    /**
     * Initializes a menu and a game
     *
     * @throws InterruptedException
     */
    public void init() throws InterruptedException {

        menu.optionMenu();
        startGame();
    }

    /**
     * Starts the game.
     * Initializes the board, player and score board
     * Loop the game until the player looses
     * When the player looses the game is restarted
     *
     * @throws InterruptedException
     */
    public void startGame() throws InterruptedException {

        lineList = new LinkedList<>();
        board = new Field();
        player = new Player(keyboard);
        scoreboard = new ScoreBoard();

        try {
            gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        menu.gameOver();
        board.resetField();
        init();
    }


    /**
     * The game will run until the space key is pressed to pause the game. While game is running,
     * the level and score points are shown in the screen
     *
     *
     * @throws InterruptedException
     */
    private void gameLoop() throws InterruptedException {

        int delayLine = 0;
        int delayBall = 0;
        score = 0;
        gameLoop = false;

        while(!gameLoop){

            scoreboard.showPoints(score);
            scoreboard.showLevel(level);

            Thread.sleep(delay);

            if(keyboard.input() == 32) pauseControl = !pauseControl;

            if (!pauseControl){
                if(60/delay == delayBall){
                    player.moveBall();
                    crash();
                    delayBall = 0;
                }

                if(175/delay == delayLine){

                    moveLines();

                    if (newLineCounter > trigger) {
                        create();
                    }

                    gameLevel();

                    newLineCounter++;
                    delayLine = 0;
                }

                delayLine++;
                delayBall++;

            }
        }
    }

    /**
     * Creates a line with visible and invisible cubes and add them to the line list
     */
    private void create() {

        Line line = new Line(numberOfHoles);
        setFieldLine(line);
        lineList.add(line);
        newLineCounter = 0;
    }

    /**
     * Moves the lines along the board
     */
    private void moveLines() {

        Iterator<Line> it = lineList.iterator();
        Line line;

        while (it.hasNext()) {
            line = it.next();
            clearFieldLine(line);

            if (line.getLineRow() >= 14) {
                it.remove();
                score++;
            } else {
                line.incrementLineRow();
                setFieldLine(line);
            }
        }
    }

    /**
     * Deletes a line in the board by setting invisible all the cubes in that line
     *
     * @param line the line that will be deleted from the board
     */
    private void clearFieldLine(Line line) {

        Cube[] cube = board.getCubeArray(line.getLineRow());

        for (int i = 0; i < cube.length; i++) {
            cube[i].setVisible(false);
        }

    }

    /**
     * Shows a line in the board by setting visible the cubes in that line
     *
     * @param line the line that will be showed in the board
     */
    private void setFieldLine(Line line) {

        Cube[] cube = board.getCubeArray(line.getLineRow());

        for (int i = 0; i < cube.length; i++) {
            cube[i].setVisible(line.getLine()[i]);
        }
    }


    private void gameLevel() {

        levelCounter++;

        if (levelCounter > (numberOfHoles * 50)) {
            levelCounter = 0;
            if (trigger != 1) {
                trigger = trigger - 2;

                if (trigger == 9 || trigger == 5 || trigger == 3) {
                    numberOfHoles++;
                }

                if(trigger == 5 || trigger == 3 || trigger == 1){
                    level++;
                }

            } else {
                if (numberOfHoles != 1) {
                    numberOfHoles--;
                    level++;
                }
            }
        }

    }

    /**
     * Iterates each line in the list and checks if the ball matches any cube in that line
     */
    private void crash() {

        Iterator<Line> it = lineList.iterator();
        Line line;

        while (it.hasNext()) {
            line = it.next();

            if (line.getLineRow() >= 14) {
                if (line.getLine()[player.getCol()]) {
                    player.deleteBall(player.getCol());

                    gameLoop = true;
                }
            }
        }
    }
}
