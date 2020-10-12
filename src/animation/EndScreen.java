package animation;

import biuoop.DrawSurface;
import game.Consts;
import game.Counter;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

/**
 * The type End screen.
 * draw the End screen after winning or losing in the game.
 */
public class EndScreen implements Animation {
    private boolean win;
    private Counter score;

    /**
     * Instantiates a new End screen.
     *
     * @param win   boolean variable if the player win or lose the game.
     * @param score the score of the game.
     */
    public EndScreen(boolean win, Counter score) {
        this.win = win;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (win) {
            try {
                Image winningImage = ImageIO.read(new File("images\\winning image.jpg"));
                d.drawImage(0, 0, winningImage);
            } catch (Exception ignored) {
                ;
            }
            d.drawText(Consts.X_AXIS_START_OF_MESSAGE, Consts.Y_AXIS_START_OF_MESSAGE,
                    "You Win! Your score is " + score.getValue(), Consts.MESSAGE_FONT_SIZE);
        } else {
            try {
                Image lose = ImageIO.read(new File("images\\GameOver screen.jpg"));
                d.drawImage(0, 0, lose);
            } catch (Exception ignored) {
                ;
            }
            d.drawText(Consts.X_AXIS_START_OF_MESSAGE, Consts.Y_AXIS_START_OF_MESSAGE,
                    "Game Over. Your score is " + score.getValue(), Consts.MESSAGE_FONT_SIZE);
        }

    }

    @Override
    public boolean shouldStop() {
        return false;
    }

}
