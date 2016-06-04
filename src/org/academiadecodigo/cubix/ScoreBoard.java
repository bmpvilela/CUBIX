package org.academiadecodigo.cubix;

import org.academiadecodigo.cubix.gameobjects.Cube;
import org.academiadecodigo.cubix.simplegfx.ScoreBoardSgfx;

/**
 * Created by codecadet on 03/06/16.
 */
public class ScoreBoard {

    private int score;
    private Cube[][] cubeField = new Cube[15][9];

    private RepresentableScoreBoard sGraphicsScoreBoard;

    public ScoreBoard(){

        sGraphicsScoreBoard = new ScoreBoardSgfx();
    }

    public void showPoints(int score){
        sGraphicsScoreBoard.showPoints(score);
    }

}
