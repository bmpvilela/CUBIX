package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.scoreboard.RepresentableScoreNumber;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreNumberSgfx implements RepresentableScoreNumber{
    private Picture pic;


    /**
     * Creates the graphic representation of the score number
     *
     * @param score the score number
     */
    public ScoreNumberSgfx(int score){
        pic = new Picture("art/score/" + score + ".png");
    }

    @Override
    public void draw() {
        pic.draw();
    }

    @Override
    public void delete() {
        pic.delete();
    }

}
