package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.Consts;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

/**
 * The type Lives indicator.
 * indicate the lives that remained to the user in the game according to the counter in the gameLevel.
 */
public class LivesIndicator implements Sprite {
    private GameLevel gameLevel;


    @Override
    public void drawOn(DrawSurface d) {
        try {
            Image heart = ImageIO.read(new File("images\\heart.png"));
            d.setColor(Color.BLACK);
            for (int i = 0; i < gameLevel.getLives().getValue(); i++) {
                d.drawImage(Consts.LIVES_IMAGE_X_AXIS + i * Consts.LIVES_IMAGE_SIZE, Consts.LIVES_IMAGE_Y_AXIS, heart);
                d.drawText(Consts.LIVES_X_AXIS, Consts.LIVES_Y_AXIS, "Lives: ", Consts.LIVES_FONT_SIZE);
            }
        } catch (IOException exception) {
            d.drawText(Consts.LIVES_X_AXIS_INDICATOR, Consts.LIVES_Y_AXIS,
                    "Lives: " + gameLevel.getLives().getValue(), Consts.LIVES_FONT_SIZE);
        }
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        this.gameLevel = g;
    }
}
