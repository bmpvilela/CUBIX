package org.academiadecodigo.cubix;

/**
 * Created by codecadet on 23/05/16.
 */
public class Position {

    private int col;
    private int row;


    // GETTERS && SETTERS:

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    /**
     * The position is equal if both rows are equals
     *
     * @param p
     * @return
     */
    public boolean equals(Position p){
        return this.row == p.getRow();
    }

}
