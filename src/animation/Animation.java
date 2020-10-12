package animation;

import biuoop.DrawSurface;

/**
 * The interface animation.Animation.
 */
public interface Animation {
    /**
     * Do one frame.
     * draw everything that needs to happen in particular frame.
     *
     * @param d the DrawSurface who the method use to draw.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Should stop boolean.
     * check the boolean variable who in charge of the stopping the frame and return it.
     *
     * @return the boolean
     */
    boolean shouldStop();
}