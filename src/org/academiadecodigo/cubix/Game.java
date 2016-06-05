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

    private LinkedList<Line> lineList;
    private int delay = 5;
    private boolean gameLoop;

    private Menu menu;
    private Field board;
    private Player player;
    private ScoreBoard scoreboard;

    private int numberOfHoles;
    private int newLineCounter;
    private int trigger; //number of loops to create a new line
    private int levelCounter;
    private int level;
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
     * Initializes the line list, board, player and score board
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
        System.gc();

        gameLoop();

        menu.gameOver();
        board.resetField();
        init();
    }


    /**
     * The game will run until the space key is pressed to pause. While game is running,
     * the level and score points are shown in the screen
     *
     * The game will run in a loop with a master delay. When the counters(delayBall and delayLine),
     * are equals to the division between the number defined by the programmer and the master delay,
     * the game objects(ball or lines) will move in different times and speeds.
     * Then the game reset the counters.
     *
     * @throws InterruptedException
     */
    private void gameLoop() throws InterruptedException {

        int delayLine = 0;
        int delayBall = 0;

        numberOfHoles = 1;
        score = 0;
        level = 1;
        trigger = 15;
        gameLoop = false;

        while(!gameLoop){

            scoreboard.showPoints(score);
            scoreboard.showLevel(level);

            Thread.sleep(delay);

            if(keyboard.input() == 32) {
                pauseControl = !pauseControl;
                Thread.sleep(500);
            }

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
     * Iterates the line list and for each line
     * moves the line along the board.
     *
     * If the line is in the last position of
     * the board it will be removed.
     *
     * If not it will clear that line in the board and then
     * increment the position and show the new line in the board.
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
     * Hide a line in the board by setting invisible all the cubes in that line
     *
     * @param line the line that will be hidden in the board
     */
    private void clearFieldLine(Line line) {

        Cube[] cube = board.getCubeArray(line.getLineRow());

        for (int i = 0; i < cube.length; i++) {
            cube[i].setVisible(false);
        }

    }

    /**
     * Shows a line in the board by setting the visibility of the cubes in that line
     *
     * @param line the line that will be showed in the board
     */
    private void setFieldLine(Line line) {

        Cube[] cube = board.getCubeArray(line.getLineRow());

        for (int i = 0; i < cube.length; i++) {
            cube[i].setVisible(line.getLine()[i]);
        }
    }

    /**
     * Defines the logic for the spaces between the lines,
     * by decreasing the trigger value by 2.
     *
     * When each time is decreased we evaluate if is equals to 9 or 5 or 3,
     * and then it will increment the number of holes. If it is 5 or 3 we increment the level too.
     *
     * Else it will decrease the number of holes and increase the level.
     * This happens when the game reaches the lowest trigger value.
     */
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
