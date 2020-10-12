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
import java.util.Random;

/**
 * The type Level 2.
 *  * the class level 2, implement and hold the level 2 information.
 */
public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return Consts.LVL2_NUMBER_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < numberOfBalls(); i++) {
            velocities.add(new Velocity(Velocity.fromAngleAndSpeed(
                    Consts.START_ANGLE_VELOCITY + Consts.LVL2_VELOCITY_ANGLE_STEP * i, Consts.SPEED_VELOCITY)));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return Consts.PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return Consts.LVL2_PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Level2Background(this);
    }

    @Override
    public List<Block> blocks() {
        Random random = new Random();

        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < numberOfBlocksToRemove(); i++) {
            Color color = new Color(random.nextInt(0xFFFFFF));
            blocks.add(new Block(new Rectangle(
                    new Point(Consts.BORDER_WIDTH + i * Consts.BLOCK_WIDTH, Consts.LVL2_BLOCK_UPPER_LEFT_Y),
                    Consts.BLOCK_WIDTH, Consts.BLOCK_HEIGHT),
                    color));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return Consts.LVL2_NUMBER_OF_BLOCKS;
    }
}
