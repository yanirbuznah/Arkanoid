package levels;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.Consts;
import sprites.Sprite;

import java.awt.Color;

/**
 * The type Level 1 background.
 * draw the level 1 background for any given time
 */
public class Level1Background implements Sprite {
    private Level1 level1;

    /**
     * Instantiates a new Level 1 background.
     *
     * @param level1 the level 1
     */
    public Level1Background(Level1 level1) {
        this.level1 = level1;
    }

    /**
     * Draw target.
     *
     * @param d the DrawSurface who with it the drawing is done
     */
    private void drawTarget(DrawSurface d) {
        d.setColor(Color.BLUE);
        //the circles
        d.drawCircle(Consts.TARGET_X_CENTER, Consts.TARGET_Y_CENTER, Consts.INNER_TARGET_RADIUS);
        d.drawCircle(Consts.TARGET_X_CENTER, Consts.TARGET_Y_CENTER, Consts.MIDDLE_TARGET_RADIUS);
        d.drawCircle(Consts.TARGET_X_CENTER, Consts.TARGET_Y_CENTER, Consts.EXTERNAL_TARGET_RADIUS);
        //the lines
        d.drawLine(Consts.TARGET_X_CENTER, Consts.START_Y_LINE, Consts.TARGET_X_CENTER, Consts.END_Y_LINE);
        d.drawLine(Consts.START_X_LINE, Consts.TARGET_Y_CENTER, Consts.END_X_LINE, Consts.TARGET_Y_CENTER);
    }

    @Override
    public void drawOn(DrawSurface d) {
        //background color
        d.setColor(Color.BLACK);
        d.fillRectangle(0, Consts.BORDER_SIZE, Consts.W_WIDTH, Consts.W_HEIGHT);
        //the name of the level
        d.drawText(Consts.NAME_X_AXIS, Consts.NAME_Y_AXIS, "Level Name: " + level1.levelName(), Consts.NAME_SIZE);
       //draw the target
        drawTarget(d);

    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
