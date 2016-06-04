package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableScoreBoard;
import org.academiadecodigo.cubix.ScoreBoard;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 03/06/16.
 */
public class ScoreBoardSgfx implements RepresentableScoreBoard {

    private Text text;

    public ScoreBoardSgfx(){
        text = new Text(70,680,"POINTS: 200 | LEVEL: 4");
    }

    public void delete() {
        text.delete();
    }

    public void draw() {
        text.draw();
    }

    @Override
    public void showPoints(int points){
        delete();
        //
        draw();
    }

}
