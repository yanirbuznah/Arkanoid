package listeners;

import sprites.Ball;
import sprites.Block;

/**
 * The interface Hit listener.
 *
 */
public interface HitListener {
    /**
     * Hit event.
     * Receives hit information, and updates the appropriate class and methods.
     * @param beingHit the block who being hit by the ball.
     * @param hitter   the hitter ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}