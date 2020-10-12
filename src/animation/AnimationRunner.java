package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import game.Consts;

/**
 * The type animation.Animation runner.
 * The class take animation.Animation object and run it.
 */
public class AnimationRunner {
    private final GUI gui;
    private final int framesPerSecond;
    private final Sleeper sleeper = new Sleeper();

    /**
     * Instantiates a new animation.Animation runner.
     *
     * @param gui             the gui window where the animation should run
     * @param framesPerSecond the frames per second in the loop animation.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * Run.
     * The method who run the animation loop.
     *
     * @param animation the animation who should run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = Consts.SECOND_IN_MILLISECONDS / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
