package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;
import game.GameEnvironment;
import geometry.Line;
import geometry.Point;
import geometry.Velocity;

import java.awt.Color;

/**
 * The type sprites.Ball.
 * Implementation of a 2-d sprites.Ball with radius, center point, color and velocity.
 */
public class Ball implements Sprite {
    private final int r;
    private final java.awt.Color color;
    private Point center;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * Instantiates a new sprites.Ball.
     *
     * @param center the center of the ball
     * @param r      the radius of the ball
     * @param color  the color
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
    }

    /**
     * Instantiates a new sprites.Ball.
     *
     * @param x      the x coordinate
     * @param y      the y coordinate
     * @param radius the radius of the ball
     * @param color  the color
     */
    public Ball(double x, double y, int radius, Color color) {
        this.center = new Point(x, y);
        this.r = radius;
        this.color = color;
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public double getX() {
        return center.getX();
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public double getY() {
        return center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size (radius) of the ball
     */
    public int getSize() {
        return r;
    }

    /**
     * Gets color.
     *
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return color;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) getX(), (int) getY(), r);
        surface.setColor(Color.BLACK);
        surface.drawCircle((int) getX(), (int) getY(), r);

    }

    /**
     * Draw on circle.
     * draw the circle without edge to the screen with the given DrawSurface.
     *
     * @param surface the surface
     */

    public void drawOnCircle(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle((int) getX(), (int) getY(), r);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        this.setGameEnvironment(g.getEnvironment());
        g.addSprite(this);
    }

    /**
     * Sets velocity.
     *
     * @param dx the dx (symbol of small change of the x coordinate).
     * @param dy the dy(symbol of small change of the y coordinate).
     */
    public void setVelocity(double dx, double dy) {
        velocity = new Velocity(dx, dy);
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return velocity;
    }

    /**
     * Sets velocity.
     *
     * @param v the velocity.
     */
    public void setVelocity(Velocity v) {
        velocity = new Velocity(v);
    }

    /**
     * Move one step.
     * checks if the ball reaches the edge of the screen by using the center of the ball, the radius and the dx/dy, and
     * change its vertical and horizontal direction of velocity according that.
     *
     * @param upperBound the upper bound of the screen
     * @param lowerBound the lower bound of the screen
     */
    public void moveOneStep(int upperBound, int lowerBound) {
        //change the location of the ball to the next location by add dx and dy to the center point.
        boolean afterChange = false;
        //checks if the ball reaches the edge of the screen by using the center of the ball, the radius and the dx/dy.
        if (center.getX() + r + getVelocity().getDx() > upperBound) {
            //check the ralative step of the x coordinate to apply it on the y coordinate
            double relativeStep = (upperBound - center.getX() - r) / (getVelocity().getDx());
            // move the ball to the edge.
            center.setX(upperBound - r);
            center.setY(center.getY() + velocity.getDy() * relativeStep);
            //change the direction of the horizontal velocity
            setVelocity(-velocity.getDx(), velocity.getDy());
            //change the boolean flag
            afterChange = true;
        }
        if (center.getX() - r + getVelocity().getDx() < lowerBound) {
            double relativeStep = (center.getX() - r - lowerBound) / (-getVelocity().getDx());
            center.setX(lowerBound + r);
            center.setY(center.getY() + velocity.getDy() * relativeStep);
            setVelocity(-velocity.getDx(), velocity.getDy());
            afterChange = true;
        }
        if (center.getY() + r + getVelocity().getDy() > upperBound) {
            //in case there was one change already, change only the y coordinate
            if (afterChange) {
                setVelocity(velocity.getDx(), -velocity.getDy());
                center.setY(upperBound - r);
            } else {
                double relativeStep = (upperBound - center.getY() - r) / (getVelocity().getDy());
                center.setY(upperBound - r);
                center.setX(center.getX() + velocity.getDx() * relativeStep);
                setVelocity(velocity.getDx(), -velocity.getDy());
                afterChange = true;
            }
        }
        if (center.getY() - r + getVelocity().getDy() < lowerBound) {
            if (afterChange) {
                setVelocity(velocity.getDx(), -velocity.getDy());
                center.setY(lowerBound + r);
            } else {
                double relativeStep = (center.getY() - r - lowerBound) / (-getVelocity().getDy());
                center.setY(lowerBound + r);
                center.setX(center.getX() + velocity.getDx() * relativeStep);
                setVelocity(velocity.getDx(), -velocity.getDy());
                afterChange = true;
            }
        }
        if (!afterChange) {
            center = getVelocity().applyToPoint(center);
        }

    }


    /**
     * Move one step.
     * move the ball around the screen, and make sure that when it collides with any collidable
     * the ball will change its vertical and horizontal direction of velocity according that.
     */
    public void moveOneStep() {
        Line trajectory = new Line(center, getVelocity().applyToPoint(center));
        CollisionInfo info = gameEnvironment.getClosestCollision(trajectory);
        if (info == null) {
            center = getVelocity().applyToPoint(center);
            return;
        }
        //in case of collision, move the ball close to the collision point.
        Velocity v = new Velocity(-velocity.getDx() / r, -velocity.getDy() / r);
        center = v.applyToPoint(center);
        //set the new velocity by using hit method.
        this.setVelocity(info.collisionObject().hit(this, info.collisionPoint(), velocity));

    }

    /**
     * Sets game environment.
     *
     * @param environment the game environment.
     */
    public void setGameEnvironment(GameEnvironment environment) {
        this.gameEnvironment = environment;
    }


    /**
     * Remove the ball from the game.
     *
     * @param gameLevel the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * Sets center.
     *
     * @param ballCenter the new center
     */
    public void setCenter(Point ballCenter) {
        this.center = ballCenter;
    }
}