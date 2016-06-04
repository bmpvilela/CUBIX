package org.academiadecodigo.cubix.simplegfx;

import org.academiadecodigo.cubix.RepresentableScoreLevel;
import org.academiadecodigo.simplegraphics.graphics.Picture;

/**
 * Created by codecadet on 04/06/16.
 */
public class ScoreLevelSgfx implements RepresentableScoreLevel{

    private Picture pic;

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

    public void showLevel(int level) {
        delete();
        draw();
    }
}
