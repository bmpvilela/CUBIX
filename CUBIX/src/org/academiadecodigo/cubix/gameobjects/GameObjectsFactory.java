package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public class GameObjectsFactory {

    private GameObjects[] gameObjects;
    private Position pos; // this pos is related to the line of the cubes


    public GameObjectsFactory(){

        gameObjects = new GameObjects[9];
        pos = new Position(); // the position is already 0,0 because the properties from the position are int (0 by default)


    }

    public void createCube(){

        // main loop para cada indice do array, meter um cubo
        // fazer set à coluna dos cubos, sendo o mesmo indice do loop

        for(int i = 0; i < gameObjects.length; i++){
            gameObjects[i] = new Cube();
            gameObjects[i].getPos().setCol(i);
        }

        // metodo abrirBuracos();

    }

}
