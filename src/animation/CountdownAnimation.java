package animation;

import biuoop.DrawSurface;
import biuoop.Sleeper;
import game.Consts;
import sprites.SpriteCollection;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;


/**
 * The type Countdown animation.
 * draw the animation of the counting from 3 to 1 before the game begin.
 */
public class CountdownAnimation implements Animation {
    private SpriteCollection gameScreen;
    private double numOfSeconds;
    private int countFrom;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the number of seconds between the count
     * @param countFrom    the number from which to count
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);

        if (countFrom > 0) {
            d.setColor(Color.BLACK);
            d.fillCircle(Consts.X_CIRCLE_CENTER, Consts.Y_CIRCLE_CENTER, Consts.CIRCLE_RADIUS);
            d.setColor(Color.RED);
            if (countFrom == 2) {
                d.setColor(Color.YELLOW);
            }
            if (countFrom == 1) {
                d.setColor(Color.GREEN);
            }
            d.fillCircle(Consts.X_CIRCLE_CENTER, Consts.Y_CIRCLE_CENTER, Consts.CIRCLE_RADIUS);
            d.setColor(Color.BLACK);
            d.drawText(Consts.NUMBER_X_AXIS, Consts.NUMBER_Y_AXIS, "" + countFrom, Consts.NUMBER_FONT_SIZE);
        }
        if (countFrom == 0) {
            try {
                Image heart = ImageIO.read(new File("images\\goSign.png"));
                d.drawImage(Consts.IMAGE_UPPERLEFT_X_AXIS, Consts.IMAGE_UPPERLEFT_Y_AXIS, heart);
            } catch (Exception ignore) {
                d.drawText(Consts.TEXT_X_AXIS, Consts.TEXT_Y_AXIS, "Go!", Consts.NUMBER_FONT_SIZE);
            }
        }
        if (countFrom != 3) {
            new Sleeper().sleepFor((int) numOfSeconds);
        }
        this.countFrom--;

    }

    @Override
    public boolean shouldStop() {
        return countFrom < -1;
    }
}