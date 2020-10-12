package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import game.Consts;
import game.Counter;
import game.GameEnvironment;
import geometry.Point;
import geometry.Rectangle;
import levels.LevelInformation;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.HitListener;
import listeners.ScoreTrackingListener;
import sprites.*;

import java.awt.Color;
import java.util.List;


/**
 * The type animation.GameLevel.
 * initialize and run the game level.
 */
public class GameLevel implements Animation {

    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private GUI gui;
    private Counter remainingBlocks = new Counter();
    private Counter remainingBalls = new Counter();
    private Counter score;
    private Counter lives;
    private Paddle paddle;
    private KeyboardSensor keyboard;
    private HitListener ballRemover;
    private HitListener blockRemover;
    private HitListener scoreListener;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;

    /**
     * Instantiates a new Game level.
     *
     * @param gui   the GUI window
     * @param li    the level information.
     * @param ks    the KeyBoard sensor
     * @param ar    the animation.Animation runner
     * @param scr   the currently score
     * @param lives the currently lives
     */
    public GameLevel(GUI gui, LevelInformation li, KeyboardSensor ks, AnimationRunner ar, Counter scr, Counter lives) {
        this.gui = gui;
        this.levelInformation = li;
        this.keyboard = ks;
        this.runner = ar;
        this.score = scr;
        this.lives = lives;
    }

    /**
     * Add collidable.
     * add collisable object to the game environment.
     *
     * @param c the collidable object.
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }

    /**
     * Add sprite.
     * add sprite object to the game environment.
     *
     * @param s the sprite object.
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }

    /**
     * Listeners initialize.
     */
    private void listenersInitialize() {
        this.ballRemover = new BallRemover(this, remainingBalls);
        this.blockRemover = new BlockRemover(this, remainingBlocks);
        this.scoreListener = new ScoreTrackingListener(this.score);
    }

    /**
     * Balls initialize.
     */
    private void ballsInitialize() {

        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(400, 575, 4, Color.WHITE);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
        }
        this.remainingBalls.increase(levelInformation.numberOfBalls());
    }

    /**
     * Game borders initialize.
     */
    private void bordersInitialize() {
        Block upperBorder = new Block(new Rectangle(new Point(0, Consts.BORDER_SIZE), Consts.W_WIDTH,
                Consts.BORDER_SIZE), Color.gray);
        upperBorder.addToGame(this);
        Block leftBorder = new Block(new Rectangle(new Point(0, Consts.BORDER_SIZE), Consts.BORDER_SIZE,
                Consts.W_HEIGHT - Consts.BLOCK_HEIGHT), Color.gray);
        leftBorder.addToGame(this);
        Block rightBorder = new Block(new Rectangle(new Point(Consts.W_WIDTH - Consts.BORDER_SIZE,
                Consts.BORDER_SIZE), Consts.BORDER_SIZE, Consts.W_HEIGHT - Consts.BORDER_SIZE), Color.gray);
        rightBorder.addToGame(this);
        Block deathRegion = new Block(new Rectangle(new Point(Consts.BORDER_SIZE, Consts.W_HEIGHT),
                Consts.W_WIDTH - 2 * Consts.BORDER_SIZE, Consts.BORDER_SIZE), Color.gray);
        deathRegion.addHitListener(ballRemover);
        deathRegion.addToGame(this);
    }

    /**
     * sprites.Block initialize.
     */
    private void blockInitialize() {
        List<Block> blocks = levelInformation.blocks();
        for (Block block : blocks) {
            block.addHitListener(blockRemover);
            block.addHitListener(scoreListener);
            block.addToGame(this);
        }
        this.remainingBlocks.increase(levelInformation.numberOfBlocksToRemove());


    }

    /**
     * sprites.Paddle initialize.
     */
    private void paddleInitialize() {

        paddle = new Paddle(new Rectangle(new Point(Consts.SCREEN_WIDTH / 2 - 0.5 * levelInformation.paddleWidth(),
                Consts.W_HEIGHT - 2 * Consts.PADDLE_HEIGHT), levelInformation.paddleWidth(),
                Consts.PADDLE_HEIGHT), Color.ORANGE, keyboard);
        paddle.addToGame(this);

    }

    /**
     * Initialize.
     * Initialize a new game: create the sprites and the collidable objects with the suitable methods
     * and add them to the game.
     */
    public void initialize() {
        levelInformation.getBackground().addToGame(this);
        new ScoreIndicator().addToGame(this);
        new LivesIndicator().addToGame(this);
        listenersInitialize();
        bordersInitialize();
        blockInitialize();


    }


    /**
     * Remove collidable.
     *
     * @param c the collidable that the method remove from the game environment.
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     *
     * @param s the sprite that the method remove from the game environment.
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * Gets environment.
     *
     * @return the game environment.
     */
    public GameEnvironment getEnvironment() {
        return environment;
    }

    /**
     * Gets score.
     *
     * @return the game.Counter that holds the score.
     */
    public Counter getScore() {
        return score;
    }


    /**
     * Gets lives.
     *
     * @return the currently status of the lives
     */
    public Counter getLives() {
        return lives;
    }

    /**
     * Play one turn.
     * run the current animator runners.
     */
    public void playOneTurn() {
        paddleInitialize();
        ballsInitialize();
        this.runner = new AnimationRunner(this.gui, Consts.FRAME_PER_SECOND);
        this.running = true;
        this.runner.run(new CountdownAnimation(Consts.SECOND_IN_MILLISECONDS * Consts.SLEEPER_PAUSE,
                Consts.COUNT_NUMBER, sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

    }

    @Override
    public void doOneFrame(DrawSurface d) {

        this.sprites.notifyAllTimePassed();
        this.sprites.drawAllOn(d);

        if (this.keyboard.isPressed("p") || (this.keyboard.isPressed("P") || (this.keyboard.isPressed("פ")))) {
            this.runner.run(new KeyPressStoppableAnimation(
                    keyboard, "space", new PauseScreen()));
        }

        if (remainingBalls.getValue() == 0) {
            paddle.removeFromGame(this);
            lives.decrease(1);
            this.running = false;
        }
        if (remainingBlocks.getValue() == 0) {
            score.increase(Consts.FINISH_LEVEL_BONUS);
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * Gets remaining blocks.
     *
     * @return the remaining blocks counter.
     */
    public Counter getRemainingBlocks() {
        return remainingBlocks;
    }
}
