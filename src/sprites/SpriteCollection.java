package sprites;

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * The type sprites.Sprite collection.
 * This class will create the sprites.Sprite collection of the game.
 */
public class SpriteCollection {
    private List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * Add sprite.
     * add the given sprite to the sprite collection (list of sprites objects).
     *
     * @param s the given sprites.Sprite.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Remove sprite.
     * Remove the given sprite from the sprite collection (list of sprites objects).
     * @param s the given sprites.Sprite.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * Notify all time passed.
     * notify all of the sprites the time passed, by calling timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesList = new ArrayList<>(sprites);
        for (Sprite sprite : spritesList) {
            sprite.timePassed();
        }

    }

    /**
     * Draw all on.
     * Draw all of the sprites with the DrawSurface, by calling drawOn(d) on all sprites.
     *
     * @param d the DrawSurface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}