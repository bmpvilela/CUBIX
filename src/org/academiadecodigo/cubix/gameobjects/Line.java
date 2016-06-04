package org.academiadecodigo.cubix.gameobjects;

import org.academiadecodigo.cubix.Position;

/**
 * Created by codecadet on 01/06/16.
 */
public class Line {

    private boolean[] line = new boolean[9]; // array de boleanos que vai desenhar as linhas
    private Position pos;

    /**
     * Creates a new line with the respective cube visibility
     *
     * @param numberOfHoles the number of hidden cubes
     */
    public Line(int numberOfHoles){

        pos = new Position();
        setLineTrue();
        openSpace(numberOfHoles);
    }

    /**
     * Set all cubs visibility in the line to true
     */
    private void setLineTrue(){

        for (int i = 0; i < line.length;i++) {
            line[i] = true;
        }
    }

    /**
     * Chooses a random position in the line and hide the cube in that position
     * It does not hide two followed cubes if the position is in the border
     *
     * @param numberOfHoles the number of hidden cubes
     */
    private void openSpace(int numberOfHoles){

        int counter = 0;
        int holePosition;

        while(counter < numberOfHoles){

            holePosition = (int) (Math.random() * line.length);

            if (holePosition == 0) {
                if( line[holePosition] && line[holePosition + 1] ) {
                    line[holePosition] = false;
                    counter++;
                }
            } else if (holePosition == 8) {
                if( line[holePosition] && line[holePosition - 1] ) {
                    line[holePosition] = false;
                    counter++;
                }
            } else {
                line[holePosition] = false;
                counter++;
            }
        }
    }

    // get line row to compare with field lines
    /**
     * Gets the line row position
     *
     * @return the line row position
     */
    public int getLineRow() {
        return pos.getRow();
    }

    // increment line row to make it move down

    /**
     * Changes the line row position
     */
    public void incrementLineRow(){
        pos.setRow(pos.getRow() + 1);
    }


    //Getters and setters
    public boolean[] getLine() {
        return line;
    }
}
