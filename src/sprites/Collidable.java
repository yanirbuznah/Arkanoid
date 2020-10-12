package sprites;

import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

/**
 * The interface sprites.Collidable.
 * This class will create the sprites.Collidable interface.
 */
public interface Collidable {
    /**
     * Gets collision rectangle.
     *
     * @return the collision rectangle.
     */
    Rectangle getCollisionRectangle();

    /**
     * Hit method. Notify the object that we collided with it at collisionPoint with a given velocity.
     * and return the new velocity expected after the hit
     *
     * @param hitter          the ball who hit the collidable.
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return geometry.Velocity - the new velocity of the ball.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}