package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */

public class Game {

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

    public Game(){
        lineList = new LinkedList<>();
        board = new Field();
        player = new Player();
        time = System.currentTimeMillis();
    }

    public void startGame() throws InterruptedException{

        int delayLine = 0;
        int delayBall = 0;

        while(!gameLoop){

            Thread.sleep(delay);

            if(65/delay == delayBall){
                player.moveBall();
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

        System.out.println("Score: " + score);
        System.out.println("CRASH!!! GAME OVER!!!");
    }

    private void create(){
        Line line = new Line(numberOfHoles);
        setFieldLine(line);
        lineList.add(line);
        newLineCounter = 0;
    }

    private void moveLines(){

        Iterator<Line> it = lineList.iterator();
        Line line;

        while(it.hasNext()){
            line = it.next();
            clearFieldLine(line);

            if(line.getLineRow() >= 14){
                crash(line);
                it.remove();
                score++;
            } else {
                line.incrementLineRow();
                setFieldLine(line);
            }
        }
    }

    private void clearFieldLine(Line line){

        Cube[] cube =  board.getCubeArray(line.getLineRow());

        for (int i = 0; i<cube.length;i++){
            cube[i].setVisible(false);
        }

    }

    private void setFieldLine(Line line){

        Cube[] cube =  board.getCubeArray(line.getLineRow());

        for (int i = 0; i<cube.length;i++){
            cube[i].setVisible(line.getLine()[i]);
        }
    }

    private void gameLevel(){
        levelCounter++;

        if(levelCounter > (numberOfHoles*50)){
            levelCounter = 0;
            if(trigger != 1){
                trigger = trigger - 2;
                if( trigger == 9 || trigger == 5 || trigger == 3){
                    numberOfHoles++;
                    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000 + " | " + "level/Holes: "+ numberOfHoles + " | " + "EmptyLines: " + trigger);
                }
            } else {
                if(numberOfHoles != 1){
                    numberOfHoles--;
                    System.out.println("Time: " + (System.currentTimeMillis()-time)/1000 + " | " + "level/Holes: "+ numberOfHoles + " | " + "EmptyLines: " + trigger);
                }
            }
        }
    }

    private void crash(Line line){
        if(line.getLine()[player.getCol()]){
            gameLoop = true;
        }
    }

}
