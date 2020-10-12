package levels;

import game.Consts;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import sprites.Block;
import sprites.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Level 1.
 * the class level 1, implement and hold the level 1 information.
 */
public class Level1 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return Consts.LVL1_NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        Velocity ballVelocity = new Velocity(Consts.LVL1_DX_VELOCITY, Consts.LVL1_DY_VELOCITY);
        velocities.add(ballVelocity);
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return Consts.PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return Consts.PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Level1Background(this);
    }

    @Override
    public List<Block> blocks() {
        Block block = new Block(new Rectangle(new Point(Consts.LVL1_BLOCK_UPPER_LEFT_X, Consts.LVL1_BLOCK_UPPER_LEFT_Y),
                Consts.LVL1_BLOCK_WIDTH, Consts.LVL1_BLOCK_HEIGHT), Color.RED);
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return Consts.LVL1_NUMBER_OF_BLOCKS;
    }
}
