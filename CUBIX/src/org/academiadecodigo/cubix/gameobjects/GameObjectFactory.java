package org.academiadecodigo.cubix.gameobjects;

/**
 * Created by codecadet on 27/05/16.
 */
public class GameObjectFactory {

    public static GameObjectsLines createGameObject(){

        GameObjectsLines gameObjectLine = new GameObjectsLines();

        gameObjectLine.setGameObjectsLines(createCubeLine()); //cria me um gameobject line e coloca dentro dela um array de cubos

        return gameObjectLine; // return game object

    }

    private static GameObjects[] createCubeLine(){

        // main loop para cada indice do arrayOfCubes, meter um cubo
        // fazer set à coluna dos cubos, sendo o mesmo indice do loop

        GameObjects[] arrayOfCubes = new GameObjects[8]; // create a arrayOfCubes to put cubes

        for(int i = 0; i < arrayOfCubes.length; i++){
            arrayOfCubes[i] = createCube(i); //Calls the createCube and return a object to put in that position

            System.out.println(arrayOfCubes[i].getPos().getCol() + " " + arrayOfCubes[i].getPos().getRow());
        }

        return arrayOfCubes; // return the cubes arrayOfCubes

        // metodo abrirBuracos();

    }

    private static GameObjects createCube(int col){
        return new Cube(col);
    }

}
