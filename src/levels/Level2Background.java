package levels;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.Consts;
import sprites.Ball;
import sprites.Sprite;

import java.awt.Polygon;
import java.awt.Color;
import java.util.Random;

/**
 * The type Level 2 background.
 * draw the level 2 background for any given time
 */
public class Level2Background implements Sprite {
    private Level2 level2;
    private Polygon[] stars = starGenerator();
    private Ball[] sunAndMoon = sunAndMoonGenerator();

    /**
     * Instantiates a new Level 2 background.
     *
     * @param level2 the level 2
     */
    public Level2Background(Level2 level2) {
        this.level2 = level2;
    }

    /**
     * Sun and moon generator ball [ ].
     *
     * @return the array with the suns and moon balls
     */
    private Ball[] sunAndMoonGenerator() {

        Ball sun1 = new Ball(Consts.SUN_CENTER, Consts.SUN_CENTER, Consts.EXTERNAL_SUN_RADIUS,
                new Color(Consts.EXTERNAL_SUN_COLOR));
        Ball sun2 = new Ball(Consts.SUN_CENTER, Consts.SUN_CENTER, Consts.MIDDLE_SUN_RADIUS,
                new Color(Consts.MIDDLE_SUN_COLOR));
        Ball sun3 = new Ball(Consts.SUN_CENTER, Consts.SUN_CENTER, Consts.INNER_SUN_RADIUS, Color.YELLOW);
        Ball moon = new Ball(Consts.SUN_CENTER, Consts.SUN_CENTER, Consts.MOON_RADIUS, Color.WHITE);
        Ball[] sunsAndMoon = {sun1, sun2, sun3, moon};
        for (Ball sunOrMoon : sunsAndMoon) {
            sunOrMoon.setVelocity(Consts.SUN_AND_MOON_VELOCITY, Consts.SUN_AND_MOON_VELOCITY);
        }

        return sunsAndMoon;

    }

    /**
     * Star generator polygon [ ].
     *
     * @return the stars array
     */
    private Polygon[] starGenerator() {

        Polygon[] starsShape = new Polygon[Consts.NUMBER_OF_STARS];
        int[] xAxis = new int[Consts.NUMBER_OF_POLYGON_POINTS];
        int[] yAxis = new int[Consts.NUMBER_OF_POLYGON_POINTS];
        for (int j = 0; j < starsShape.length; j++) {
            Random random = new Random();
            int midX = random.nextInt(Consts.W_WIDTH);
            int midY = random.nextInt(Consts.W_HEIGHT);
            for (int i = 0; i < Consts.NUMBER_OF_POLYGON_POINTS; i++) {

                double x = Math.cos(i * ((2 * Math.PI) / Consts.STARS_SCOPE))
                        * Consts.STAR_RADIUS[i % Consts.STARS_EDGE_MOD];
                double y = Math.sin(i * ((2 * Math.PI) / Consts.STARS_SCOPE))
                        * Consts.STAR_RADIUS[i % Consts.STARS_EDGE_MOD];

                xAxis[i] = (int) x + midX;
                yAxis[i] = (int) y + midY;
            }
            starsShape[j] = new Polygon(xAxis, yAxis, Consts.NUMBER_OF_POLYGON_POINTS);
        }
        return starsShape;
    }

    /**
     * Night mode.
     * draw the level background in case of night mode
     *
     * @param d the DrawSurface
     */
    private void nightMode(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, Consts.BORDER_SIZE, Consts.W_WIDTH, Consts.W_HEIGHT);
        sunAndMoon[3].moveOneStep(Consts.W_WIDTH, 0);
        sunAndMoon[3].drawOnCircle(d);
        d.setColor(Color.WHITE);
        for (Polygon star : stars) {
            d.fillPolygon(star);
        }
    }

    /**
     * Day mode.
     * draw the level background in case of day mode
     *
     * @param d the DrawSurface
     */
    private void dayMode(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, Consts.BORDER_SIZE, Consts.W_WIDTH, Consts.W_HEIGHT);
        for (int i = 0; i < 3; i++) {
            sunAndMoon[i].moveOneStep(Consts.W_WIDTH, 0);
            sunAndMoon[i].drawOnCircle(d);
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (sunAndMoon[0].getY() > Consts.W_HEIGHT) {
            nightMode(d);
        } else if (sunAndMoon[0].getY() <= Consts.W_HEIGHT || sunAndMoon[3].getY() > Consts.W_HEIGHT) {
            dayMode(d);
        }
        d.setColor(Color.BLACK);
        d.drawText(Consts.NAME_X_AXIS, Consts.NAME_Y_AXIS, "Level Name: " + level2.levelName(), Consts.NAME_SIZE);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
