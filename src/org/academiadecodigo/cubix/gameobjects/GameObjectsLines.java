package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;

/**
 * Created by codecadet on 23/05/16.
 */
public class GameObjectsLines {

    private GameObjects[] gameObjectsLines;
    private Position pos; // this pos is related to the line of the cubes

    public GameObjectsLines(){

        gameObjectsLines = new GameObjects[8];
        pos = new Position(); // the position is already 0,0 because the properties from the position are int (0 by default)

    }

    public void setGameObjectsLines(GameObjects[] gameObjectsLines) {
        this.gameObjectsLines = gameObjectsLines;
    }

    public GameObjects[] getGameObjectsLines(){return gameObjectsLines; }

    public void move(){
        pos.setRow(pos.getRow() + 1);

        for(int i = 0; i < gameObjectsLines.length; i++){
            gameObjectsLines[i].move();

            //System.out.println(gameObjectsLines[i].getPos().getCol() + " " + gameObjectsLines[i].getPos().getRow());
        }

    }

    /**
     * Returns the column position of a specific cube for collision detect with ball
     * @param index
     * @return
     */
    public boolean getCubeStatus(int index){
        return gameObjectsLines[index].isVisible();
    }

    public Position getPos() {
        return pos;
    }

    public void deleteLine(){

        for(int i = 0; i < gameObjectsLines.length; i++){
            gameObjectsLines[i].deleteCube();
        }
    }

}
