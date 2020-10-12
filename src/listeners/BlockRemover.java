package listeners;

import animation.GameLevel;
import game.Counter;
import sprites.Ball;
import sprites.Block;

/**
 * The type sprites.Block remover.
 * Removing blocks from the game, and keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * Instantiates a new sprites.Block remover.
     *
     * @param gameLevel          The game from him we wants to remove the blocks
     * @param remainingBlocks the game.Counter of the remaining Blocks in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }


    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
            beingHit.removeHitListener(this);
            beingHit.removeFromGame(this.gameLevel);
            this.remainingBlocks.decrease(1);

    }
}