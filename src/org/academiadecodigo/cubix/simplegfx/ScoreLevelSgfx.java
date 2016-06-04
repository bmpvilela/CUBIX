package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.scoreboard.RepresentableScoreLevel;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreLevelSgfx implements RepresentableScoreLevel{

    private Picture pic;

    /**
     * Creates the graphic representation of the level number
     *
     * @param level the number of the level
     */
    public ScoreLevelSgfx(int level){
        pic = new Picture("TEMPLATES/level/" + level + ".png");
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
