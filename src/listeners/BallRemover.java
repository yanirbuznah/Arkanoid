package listeners;

import animation.GameLevel;
import game.Counter;
import sprites.Ball;
import sprites.Block;

/**
 * The type sprites.Ball remover.
 * Remove the hitter ball from the game if it hit the death block (death region or killing block).
 * and keeping count of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Instantiates a new sprites.Ball remover.
     *
     * @param gameLevel      The game from him we wants to remove the balls
     * @param remainingBalls the game.Counter of the remaining Balls in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
