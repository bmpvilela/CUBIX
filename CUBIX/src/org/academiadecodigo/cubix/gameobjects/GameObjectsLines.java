package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public class GameObjectsLines {

    private GameObjects[] gameObjectsLines;
    private Position pos; // this pos is related to the line of the cubes

    //private RepresentableCube simpleGraphicsCube;

    public GameObjectsLines(){

        gameObjectsLines = new GameObjects[8];
        pos = new Position(); // the position is already 0,0 because the properties from the position are int (0 by default)

    }

    public void createCube(){

        // main loop para cada indice do array, meter um cubo
        // fazer set à coluna dos cubos, sendo o mesmo indice do loop

        for(int i = 0; i < gameObjectsLines.length; i++){
            gameObjectsLines[i] = new Cube(i);

            //simpleGraphicsCube = new CubeSgfx(gameObjectsLines[i].getPos().getCol(),gameObjectsLines[i].getPos().getRow());
            //simpleGraphicsCube.init();

            System.out.println(gameObjectsLines[i].getPos().getCol() + " " + gameObjectsLines[i].getPos().getRow());
        }

        // metodo abrirBuracos();

    }

    public void move(){
        pos.setRow(pos.getRow() + 1);

        for(int i = 0; i < gameObjectsLines.length; i++){
            gameObjectsLines[i].move();
            //simpleGraphicsCube.load(gameObjectsLines[i].getPos().getCol(),gameObjectsLines[i].getPos().getRow());
        }
    }

}
