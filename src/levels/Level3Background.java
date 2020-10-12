package levels;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.Consts;
import sprites.Sprite;

import java.awt.Color;

/**
 * The type Level 3 background.
 * draw the level 3 background for any given time
 */
public class Level3Background implements Sprite {
    private Level3 level3;
    private boolean lightOn = true;
    private int counter = 0;

    /**
     * Instantiates a new Level 3 background.
     *
     * @param level3 the level 3
     */
    public Level3Background(Level3 level3) {
        this.level3 = level3;
    }


    /**
     * Building draw on.
     * draw the building in the level
     *
     * @param d the DrawSurface
     */
    private void buildingDrawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        //building body.
        d.fillRectangle(Consts.BUILDING_UPPER_LEFT_X, Consts.BUILDING_UPPER_LEFT_Y, Consts.BUILDING_WIDTH,
                Consts.BUILDING_HEIGHT);
        d.setColor(new Color(Consts.POLL_COLOR));
        d.fillRectangle(Consts.POLL_UPPER_LEFT_X, Consts.POLL_UPPER_LEFT_Y, Consts.POLL_WIDTH, Consts.POLL_HEIGHT);
        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(Consts.ANTENNA_UPPER_LEFT_X, Consts.ANTENNA_UPPER_LEFT_Y, Consts.ANTENNA_WIDTH,
                Consts.ANTENNA_HEIGHT);
        //windows
        d.setColor(Color.WHITE);
        for (int i = 0; i < Consts.WINDOWS_COLUMNS; i++) {
            for (int j = 0; j < Consts.WINDOWS_ROWS; j++) {
                d.fillRectangle(Consts.WINDOWS_START_X + i * (Consts.WINDOW_WIDTH + Consts.WINDOWS_SPACE),
                        Consts.WINDOWS_START_Y + j * (Consts.WINDOW_HEIGHT + Consts.WINDOWS_SPACE),
                        Consts.WINDOW_WIDTH, Consts.WINDOW_HEIGHT);
            }
        }

        //lights
        d.setColor(Color.RED);
        d.fillCircle(Consts.BULB_X_CENTER, Consts.BULB_Y_CENTER, Consts.BULB_EXTERNAL_RADIUS);
        d.setColor(Color.orange);
        d.fillCircle(Consts.BULB_X_CENTER, Consts.BULB_Y_CENTER, Consts.BULB_MIDDLE_RADIUS);
        if (lightOn) {
            d.setColor(Color.white);
        } else {
            d.setColor(Color.black);
        }
        d.fillCircle(Consts.BULB_X_CENTER, Consts.BULB_Y_CENTER, Consts.BULB_INNER_RADIUS);
        counter++;
        if (counter == Consts.ON_OFF_FRAMES) {
            lightOn = !lightOn;
            counter = 0;
        }

    }

    @Override
    public void drawOn(DrawSurface d) {
        //green background
        d.setColor(new Color(Consts.LVL3_BACKGROUND_COLOR));
        d.fillRectangle(0, Consts.BORDER_SIZE, Consts.W_WIDTH, Consts.W_HEIGHT);
        d.setColor(Color.BLACK);
        d.drawText(Consts.NAME_X_AXIS, Consts.NAME_Y_AXIS, "Level Name: " + level3.levelName(), Consts.NAME_SIZE);
        buildingDrawOn(d);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
