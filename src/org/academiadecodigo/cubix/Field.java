package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import org.academiadecodigo.cubix.simplegfx.FieldSgfx;

/**
 * Created by codecadet on 24/05/16.
 */

public class Field {

    private Cube[][] cubeField = new Cube[15][9]; // array multidimensional (15 linhas, 9 colunas)
    private RepresentableField simpleGraphicsField;

    // metodo construtor do Field
    public Field(){
        simpleGraphicsField = new FieldSgfx(); // instancia o simplegraphics do field
        simpleGraphicsField.init();
        createField();
    }

    // metodo para criar o field
    private void createField(){
        for (int i = 0; i < cubeField.length; i++){ // i = 15 linhas (row)
            for (int j = 0; j < cubeField[i].length; j++) { // j = 9 colunas (col)
                cubeField[i][j] = new Cube(i, j);
                System.out.println("col: " + i + " row: " + j);
            }
        }
    }

    public Cube[] getCubeArray(int row){
        return cubeField[row];
    }
}
