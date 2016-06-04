package org.academiadecodigo.cubix;

/**
 * Created by codecadet on 01/06/16.
 */
public class Line {

    private boolean[] line = new boolean[9]; // array de boleanos que vai desenhar as linhas
    private Position pos;

    public Line(int numberOfHoles){

        pos = new Position();
        setLineTrue();
        openSpace(numberOfHoles);
    }

    // põe todos as linhas a "true" (percorre todas linhas e mete-as a true)
    private void setLineTrue(){

        for (int i = 0; i < line.length;i++) {
            line[i] = true;
        }
    }

    // metodo para abrir buracos na linha
    private void openSpace(int numberOfHoles){ //TODO AddLevel Logic

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
    public int getLineRow() {
        return pos.getRow();
    }

    // increment line row to make it move down
    public void incrementLineRow(){
        pos.setRow(pos.getRow() + 1);
    }

    public boolean[] getLine() {
        return line;
    }
}
