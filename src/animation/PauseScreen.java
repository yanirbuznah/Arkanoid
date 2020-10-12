package animation;

import biuoop.DrawSurface;
import game.Consts;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;


/**
 * The type Pause screen.
 * the class who implement the pause screen between level and lives.
 */
public class PauseScreen implements Animation {

    @Override
    public void doOneFrame(DrawSurface d) {

        d.setColor(new Color(Consts.PAUSE_BACKGROUND));
        d.fillRectangle(0, 0, Consts.W_WIDTH, Consts.W_HEIGHT);
        try {
            Image pause = ImageIO.read(new File("images\\Take_A_Break.png"));
            d.drawImage(0, 0, pause);
        } catch (Exception ignored) {
            ;
        }
        d.setColor(Color.BLACK);
        d.drawText(Consts.PAUSE_X_AXIS, Consts.PAUSE_Y_AXIS, "paused -- press space to continue",
                Consts.PAUSE_FONT_SIZE);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}