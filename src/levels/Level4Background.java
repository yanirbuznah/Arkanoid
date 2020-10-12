package levels;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.Consts;
import geometry.Point;
import sprites.Ball;
import sprites.Sprite;

import java.awt.Color;
import java.util.Random;

/**
 * The type Level 4 background.
 * draw the level 4 background for any given time
 */
public class Level4Background implements Sprite {
    private Level4 level4;
    private Random random = new Random();
    private Ball[] sun = sunGenerator();
    private Ball[][] balloonsArray = {balloons(), balloons(), balloons()};


    /**
     * Instantiates a new Level 4 background.
     *
     * @param level4 the level 4
     */
    public Level4Background(Level4 level4) {
        this.level4 = level4;
    }

    /**
     * Ballons ball [ ].
     *
     * @return the balloons array
     */
    private Ball[] balloons() {

        Color[] colors = {Color.RED, Color.YELLOW, Color.green, Color.cyan, Color.pink, Color.blue, Color.magenta};
        Ball[] baloons = new Ball[Consts.NUMBER_OF_BALLOONS];
        int x = random.nextInt(Consts.W_WIDTH);
        int y = random.nextInt(Consts.W_HEIGHT);
        for (int i = 0; i < Consts.NUMBER_OF_BALLOONS; i++) {
            int radius = random.nextInt(Consts.BALLOONS_MIN_RADIUS) + Consts.BALLOONS_MAX_RADIUS
                    - Consts.BALLOONS_MIN_RADIUS;
            Color randomColor = colors[(random.nextInt(colors.length))];
            baloons[i] = new Ball(x + Consts.BALLOONS_X_DIFFERENCE * i,
                    y + Consts.BALLOONS_Y_DIFFERENCE * Math.pow(-1, i), radius, randomColor);
        }

        for (Ball ballon : baloons) {
            ballon.setVelocity(0, Consts.BALLOONS_DY_VELOCITY);
        }
        return baloons;
    }

    /**
     * Sun generator ball [ ].
     *
     * @return the sun array.
     */
    private Ball[] sunGenerator() {

        Ball sun1 = new Ball(Consts.SUN_X_AXIS_CENTER, Consts.SUN_Y_AXIS_CENTER,
                Consts.LVL4_EXTERNAL_SUN_RADIUS, new Color(Consts.LVL4_EXTERNAL_SUN_COLOR));
        Ball sun2 = new Ball(Consts.SUN_X_AXIS_CENTER, Consts.SUN_Y_AXIS_CENTER,
                Consts.LVL4_MIDDLE_SUN_RADIUS, new Color(Consts.LVL4_MIDDLE_SUN_COLOR));
        Ball sun3 = new Ball(Consts.SUN_X_AXIS_CENTER, Consts.SUN_Y_AXIS_CENTER,
                Consts.LVL4_INNER_SUN_RADIUS, Color.YELLOW);
        Ball[] suns = {sun1, sun2, sun3};
        return suns;

    }

    @Override
    public void drawOn(DrawSurface d) {

        //sky color background
        d.setColor(new Color(Consts.LVL4_SKY_COLOR));
        d.fillRectangle(0, Consts.BORDER_SIZE, Consts.W_WIDTH, Consts.W_HEIGHT);

        for (int i = 0; i < Consts.SUN_RAYS; i++) {
            d.setColor(new Color(Consts.SUN_RAY_COLOR));
            d.drawLine(Consts.SUN_X_AXIS_CENTER, Consts.SUN_Y_AXIS_CENTER,
                    Consts.SUN_RAYS_SPACES * i, Consts.BLOCKS_START_Y);
        }
        for (int i = 0; i < sun.length; i++) {
            sun[i].drawOnCircle(d);
        }
        for (Ball[] ballons : balloonsArray) {
            for (Ball ballon : ballons) {
                ballon.moveOneStep(Consts.W_WIDTH, -Consts.W_WIDTH);
                d.setColor(Color.lightGray);
                d.drawLine((int) ballon.getX(), (int) ballon.getY(),
                        (int) ballon.getX(), (int) ballon.getY() + Consts.WIRES_LENGTH);
                ballon.drawOnCircle(d);
                if (ballon.getY() + Consts.WIRES_LENGTH < 0) {
                    ballon.setCenter(new Point(random.nextInt(Consts.W_WIDTH),
                            random.nextInt(Consts.W_HEIGHT) + Consts.W_HEIGHT + Consts.BALLOONS_MAX_RADIUS));
                }
            }
        }
        d.setColor(Color.yellow);
        d.drawText(Consts.QUOTE_X_AXIS, Consts.QUOTE_Y_AXIS,
                "The world ain't all sunshine and rainbows", Consts.QUOTE_FONT_SIZE);
        d.drawText(Consts.ROCKY_X_AXIS, Consts.ROCKY_Y_AXIS, "Rocky Balboa", Consts.ROCKY_FONT_SIZE);
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, Consts.W_WIDTH, Consts.BORDER_WIDTH);
        d.setColor(Color.BLACK);
        d.drawText(Consts.NAME_X_AXIS, Consts.NAME_Y_AXIS, "Level Name: " + level4.levelName(), Consts.NAME_SIZE);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
