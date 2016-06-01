package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by codecadet on 23/05/16.
 */

public class Game {

    private LinkedList<Line> lineList = new LinkedList<Line>();
    private int delay = 25;
    private boolean gameLoop;

    private Field board;

    private int level = 1;

    public Game(){
        board = new Field();
    }

    public void startGame() throws InterruptedException{

        while(!gameLoop){

            Thread.sleep(delay);

            create();

            moveLines();

        }

    }

    private void create(){

        lineList.add(new Line(level));

    }

    private void moveLines(){

        Iterator<Line> it = lineList.iterator();
        Line line = null;

        while(it.hasNext()){
            System.out.println("ola");
            line = it.next();
            clearFieldLine(line);
            line.incrementLineRow();
            setFieldLine(line);
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

}
