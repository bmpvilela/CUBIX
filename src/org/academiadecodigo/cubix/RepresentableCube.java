package org.academiadecodigo.cubix;

/**
 * Created by codecadet on 23/05/16.
 */
public interface RepresentableCube {

    int getCol();

    int getRow();

    void init();

    void load(int col, int row);

    void delete();

}
