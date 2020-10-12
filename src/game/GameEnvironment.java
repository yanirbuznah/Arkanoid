package game;

import geometry.Line;
import geometry.Point;
import sprites.Collidable;
import sprites.CollisionInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Game environment.
 * This class will create and return the game environment (hold the collidables objects and the collisions points).
 */
public class GameEnvironment {
    private List<Collidable> collidables = new ArrayList<Collidable>();

    /**
     * Add collidable.
     * Add the given collidable object to the environment (list of collidables objects).
     *
     * @param c the collidable object.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * Remove collidable.
     * Remove the given collidable object from the environment (list of collidables objects).
     * @param c the collidable object.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * Gets closest collision.
     * check all of the collidables and the trajectory of the ball and.
     * return the information about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory of the ball.
     * @return sprites.CollisionInfo - the information of the closest collision that is going to accur.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closetCollisionPoint = null;
        Collidable collisionObject = null;
        for (Collidable collidable : collidables) {
            //save the closet intersection point in the collidable, if exist.
            Point collisionP = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
            //save the collision info of the collision.
            if (closetCollisionPoint == null) {
                closetCollisionPoint = collisionP;
                collisionObject = collidable;

                //check if there is closer collision , if exist, change the collision info accordingly
            } else if (collisionP != null
                    && collisionP.distance(trajectory.start()) < closetCollisionPoint.distance(trajectory.start())) {
                closetCollisionPoint = collisionP;
                collisionObject = collidable;
            }

        }
        if (closetCollisionPoint == null) {
            return null;
        }
        return new CollisionInfo(closetCollisionPoint, collisionObject);
    }

}