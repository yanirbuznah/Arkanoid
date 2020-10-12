package levels;

import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.util.List;

/**
 * The interface Level information.
 */
public interface LevelInformation {
    /**
     * Number of balls int.
     *
     * @return the number of balls in the current level
     */
    int numberOfBalls();

    /**
     * Initial ball velocities list.
     *
     * @return the list of the initial velocity of each ball
     */
    List<Velocity> initialBallVelocities();

    /**
     * sprites.Paddle speed int.
     *
     * @return the speed of the paddle
     */
    int paddleSpeed();

    /**
     * sprites.Paddle width int.
     *
     * @return the width of the paddle
     */
    int paddleWidth();

    /**
     * Level name string.
     *
     * @return the level name will be displayed at the top of the screen.
     */
    String levelName();

    /**
     * Gets background.
     *
     * @return the sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * Blocks list.
     *
     * @return the list of the blocks in the current level
     */
    List<Block> blocks();

    /**
     * Number of blocks to remove int.
     *
     * @return the number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}