package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import org.academiadecodigo.cubix.player.Ball;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */

public class Game {

    private LinkedList<Line> lineList = new LinkedList<Line>();
    private int delay = 75;
    private boolean gameLoop;

    private Field board;
    private Ball ball;

    private int level = 1;
    private int newLineCounter;
    private int trigger = 15; //number of loops to create a new line
    private int levelCounter;

    public Game(){
        board = new Field();
        ball = new Ball();
    }

    public void startGame() throws InterruptedException{

        while(!gameLoop){

            Thread.sleep(delay);

            moveLines();

            if (newLineCounter > trigger) {
                create();
            }

            gameLevel();

            newLineCounter++;

        }
    }

    private void create(){
        Line line = new Line(level);
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
            } else {
                line.incrementLineRow();
                setFieldLine(line);
            }
        }
    }

    private void clearFieldLine(Line line){ // TODO ?? enviar a posicao para field e pedir para limpar a linha ??

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

        if(levelCounter > (level*50)){
            levelCounter = 0;
            if(trigger != 1){
                trigger = trigger - 2;
                if( trigger == 9 || trigger == 5 || trigger == 3){
                    level++;
                }
            }
        }
    }

    private void crash(Line line){
        if(line.getLine()[ball.getCol()]){
            System.out.println("crash!!!");
            //gameLoop = true;
        }
    }

}
