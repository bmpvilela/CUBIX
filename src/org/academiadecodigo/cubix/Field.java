package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.cube.Cube;
import org.academiadecodigo.cubix.simplegfx.FieldSgfx;

/**
 * Created by codecadet on 24/05/16.
 */

public class Field {

    private Cube[][] cubeField = new Cube[15][9];
    private RepresentableField sGraphicsField;

    /**
     * Constructs a new field and initializes it
     */
    public Field(){

        sGraphicsField = new FieldSgfx();
        sGraphicsField.init();
        createField();
    }

    /**
     * Creates a cube for each column in each row.
     */
    private void createField(){

        for (int i = 0; i < cubeField.length; i++){
            for (int j = 0; j < cubeField[i].length; j++){
                cubeField[i][j] = new Cube(i, j);
            }
        }
    }

    /**
     *
     * Set each cube invisible for each column in each row.
     */
    public void resetField(){

        for (int i = 0; i < cubeField.length; i++){
            for (int j = 0; j < cubeField[i].length; j++){
                cubeField[i][j].setVisible(false);
            }
        }
    }


    /**
     * Gets all the cubes in the current row
     *
     * @param row the current row of the array os cubes
     * @return the array of cubes in the current row
     */
    public Cube[] getCubeArray(int row){
        return cubeField[row];
    }
}
