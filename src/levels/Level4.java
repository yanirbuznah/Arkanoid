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
 * The type Level 4.
 * the class level 4, implement and hold the level 4 information.
 */
public class Level4 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return Consts.LVL4_NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(new Velocity(Velocity.fromAngleAndSpeed(
                    Consts.START_ANGLE_VELOCITY + Consts.LVL4_VELOCITY_ANGLE_STEP * i, Consts.SPEED_VELOCITY)));
        }
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Level4Background(this);
    }

    @Override
    public List<Block> blocks() {
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.green, Color.white, Color.pink, Color.cyan};
        List<Block> blocks = new ArrayList<>();
        //initialize all the blocks.
        for (int i = 0; i < Consts.LVL4_BLOCKS_ROWS; i++) {
            for (int j = 0; j < Consts.LVL4_BLOCKS_COLUMNS; j++) {
                Point upperLeft = new Point(Consts.BLOCKS_START_X - j * Consts.BLOCK_WIDTH,
                        Consts.BLOCKS_START_Y + Consts.BLOCK_HEIGHT * i);
                blocks.add(new Block(new Rectangle(upperLeft, Consts.BLOCK_WIDTH, Consts.BLOCK_HEIGHT), colors[i]));
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return Consts.LVL4_NUMBER_OF_BLOCKS;
    }
}
