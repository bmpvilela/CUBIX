package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.simplegfx.CubeSgfx;
import sun.plugin2.message.GetAuthenticationMessage;

/**
 * Created by codecadet on 27/05/16.
 */
public class GameObjectFactory {

    public static GameObjectsLines createGameObject(int gameLevel){

        GameObjectsLines gameObjectLine = new GameObjectsLines();

        gameObjectLine.setGameObjectsLines(createCubeLine(gameLevel)); //cria me um gameobject line e coloca dentro dela um array de cubos

        return gameObjectLine; // return game object

    }

    private static GameObjects[] createCubeLine(int gameLevel) {

        // main loop para cada indice do arrayOfCubes, meter um cubo
        // fazer set à coluna dos cubos, sendo o mesmo indice do loop

        GameObjects[] arrayOfCubes = new GameObjects[8]; // create a arrayOfCubes to put cubes

        for (int i = 0; i < arrayOfCubes.length; i++) {
            arrayOfCubes[i] = createCube(i); //Calls the createCube and return a object to put in that position

            //System.out.println(arrayOfCubes[i].getPos().getCol() + " " + arrayOfCubes[i].getPos().getRow());
        }

        //arrayOfCubes[5].setVisible(false);
        openSpaces(arrayOfCubes, gameLevel);

        initCubeLine(arrayOfCubes);

        return arrayOfCubes; // return the cubes arrayOfCubes
    }

    private static void openSpaces(GameObjects[] arrayOfCubes, int gameLevel){

        int numberOfSpacesMin, numberOfSpacesMax;
        int totalNumberSpaces;

        switch (gameLevel){

            case 1:
                numberOfSpacesMin = gameLevel;
                numberOfSpacesMax = gameLevel;
                break;
            case 2:
                numberOfSpacesMin = 1;
                numberOfSpacesMax = gameLevel;
                break;
            case 3:
                numberOfSpacesMin = 1;
                numberOfSpacesMax = gameLevel;
                break;
            case 4:
                numberOfSpacesMin = 2;
                numberOfSpacesMax = gameLevel;
                break;
            default:
                numberOfSpacesMin = 3;
                numberOfSpacesMax = 4;
                break;
        }

        totalNumberSpaces = numberOfSpacesMin + (int)(Math.random() * ((numberOfSpacesMax - numberOfSpacesMin)+1));

        int arrayPos;
        int count = 0;

        while(count != totalNumberSpaces){
            arrayPos  = (int) (Math.random() * arrayOfCubes.length);

            /*
            if(arrayPos > 0 && arrayPos < arrayOfCubes.length){

            }

            if(arrayPos == 0){
                if (!arrayOfCubes[arrayPos+1].isVisible());
            }

            if(arrayPos == arrayOfCubes.length-1){
                arrayOfCubes[arrayPos-1];//compare
            }

            if(//compare in the midle
                    ){

            }
            */

            if(arrayOfCubes[arrayPos].isVisible()){
                arrayOfCubes[arrayPos].setVisible(false);
                count++;
            }

        }
    }

    private static GameObjects createCube(int col){
        return new Cube(col);
    }

    private static void initCubeLine(GameObjects[] arrayOfCubes){

        for (int i = 0; i < arrayOfCubes.length; i++) {
            if (arrayOfCubes[i].isVisible()) {
                arrayOfCubes[i].init();
            }
        }

    }

}
