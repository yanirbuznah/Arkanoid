package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 * indicate the score in the game according to the listeners.ScoreTrackingListener.
 */
public class ScoreIndicator implements Sprite {
    private GameLevel gameLevel;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.drawText(380, 15, "Score: " + gameLevel.getScore().getValue(), 15);
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
