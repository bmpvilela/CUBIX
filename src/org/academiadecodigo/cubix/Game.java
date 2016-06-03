package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
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

    private int numberOfHoles = 1;
    private int newLineCounter;
    private int trigger = 15; //number of loops to create a new line
    private int levelCounter;
    private int score;

    private RepresentableKeyboard keyboard;
    private boolean pauseControl;

    public Game() throws InterruptedException {
        keyboard = new KeyboardSgfx();
        menu = new Menu(keyboard);
        init();
    }


    public void init() throws InterruptedException {
        menu.optionMenu();
        startGame();
    }

    public void startGame() throws InterruptedException {

        lineList = new LinkedList<>();
        board = new Field();
        player = new Player(keyboard);
        time = System.currentTimeMillis();

        try {
            gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        menu.gameOver();
        board.resetField();
        init();

    }

    private void gameLoop() throws InterruptedException {

        int delayLine = 0;
        int delayBall = 0;
        score = 0;
        gameLoop = false;

        while(!gameLoop){

            Thread.sleep(delay);

            if(keyboard.input()==32) pauseControl = !pauseControl;

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


    System.out.println("Score: "+score);
    System.out.println("CRASH!!! GAME OVER!!!");
}

    private void create() {
        Line line = new Line(numberOfHoles);
        setFieldLine(line);
        lineList.add(line);
        newLineCounter = 0;
    }

    private void moveLines() {

        Iterator<Line> it = lineList.iterator();
        Line line;

        while (it.hasNext()) {
            line = it.next();
            clearFieldLine(line);

            if (line.getLineRow() >= 14) {
                //crash(line);
                it.remove();
                score++;
            } else {
                line.incrementLineRow();
                setFieldLine(line);
            }
        }
    }

    private void clearFieldLine(Line line) {

        Cube[] cube = board.getCubeArray(line.getLineRow());

        for (int i = 0; i < cube.length; i++) {
            cube[i].setVisible(false);
        }

    }

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
                    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000 + " | " + "level/Holes: " + numberOfHoles + " | " + "EmptyLines: " + trigger);
                }
            } else {
                if (numberOfHoles != 1) {
                    numberOfHoles--;
                    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000 + " | " + "level/Holes: " + numberOfHoles + " | " + "EmptyLines: " + trigger);
                }
            }
        }
    }

    /*
    private void crash(Line line){
        if(line.getLine()[player.getCol()]){
            gameLoop = true;
        }
    }
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
