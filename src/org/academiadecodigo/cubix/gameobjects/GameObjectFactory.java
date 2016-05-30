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

        GameObjects[] arrayOfCubes = new GameObjects[9]; // create a arrayOfCubes to put cubes

        for (int i = 0; i < arrayOfCubes.length; i++) {
            arrayOfCubes[i] = createCube(i); //Calls the createCube and return a object to put in that position
        }

        openSpaces(arrayOfCubes, gameLevel);
        initCubeLine(arrayOfCubes);

        return arrayOfCubes; // return the cubes arrayOfCubes
    }

    private static void openSpaces(GameObjects[] arrayOfCubes, int gameLevel){

        int numberOfSpacesMin, numberOfSpacesMax;
        int totalNumberSpaces;

        int arrayPos;
        int count = 0;

        /**
         * This switch defines the minimum and maximum wholes in the cube line.
         * This number depends from the game level.
         */
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

        /**
         * A random value between min and max
         */
        totalNumberSpaces = numberOfSpacesMin + (int)(Math.random() * ((numberOfSpacesMax - numberOfSpacesMin)+1));

        /**
         * Create the wholes and verify if they are created in a already clean position or they are contiguos.
         * If so, get a new position.
         */
        while(count != totalNumberSpaces){

            arrayPos  = (int) (Math.random() * arrayOfCubes.length);

            switch (arrayPos){
                case 0:
                    if (arrayOfCubes[arrayPos].isVisible() && arrayOfCubes[arrayPos+1].isVisible())
                    {
                        arrayOfCubes[arrayPos].setVisible(false);
                        count++;
                    }
                    break;

                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (arrayOfCubes[arrayPos-1].isVisible() && arrayOfCubes[arrayPos+1].isVisible()){

                        if(arrayOfCubes[arrayPos].isVisible())
                        {
                            arrayOfCubes[arrayPos].setVisible(false);
                            count++;
                        }
                    }

                    break;

                case 8: //TODO array.length not allowed
                    if (arrayOfCubes[arrayPos].isVisible() && arrayOfCubes[arrayPos-1].isVisible())
                    {
                        arrayOfCubes[arrayPos].setVisible(false);
                        count++;
                    }
                    break;

                default:
                    System.out.println("Something wrong happen here...");
                    break;
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
