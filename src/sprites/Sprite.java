package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;


/**
 * The interface sprites.Sprite.
 * This class will create the sprites.Sprite interface.
 */
public interface Sprite {
    /**
     * Draw on.
     * draw the sprite to the screen with the given DrawSurface.
     * @param d the DrawSurface.
     */
    void drawOn(DrawSurface d);

    /**
     * Time passed.
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * Add to game.
     *add the sprite to the game.
     * @param g the Game class.
     */
    void addToGame(GameLevel g);
}