package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.Consts;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;

import java.awt.Color;

/**
 * The type sprites.Paddle.
 * This class will create the sprites.Paddle object.
 */
public class Paddle implements Sprite, Collidable {

    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private Color color;
    private int step = Consts.PADDLE_SPEED;

    /**
     * Instantiates a new sprites.Paddle.
     *
     * @param rect     the rectangle shape of the paddle.
     * @param color    the color of the paddle
     * @param keyboard the keyboard the keyboard sensor to move the paddle.
     */
    public Paddle(Rectangle rect, Color color, biuoop.KeyboardSensor keyboard) {
        this.keyboard = keyboard;
        this.rectangle = rect;
        this.color = color;
    }

    /**
     * Move left.
     * move the paddle one step left.
     */
    public void moveLeft() {
        if (rectangle.getUpperLeft().getX() > Consts.BORDER_WIDTH) {
            Point newUpperLeft = new Point(
                    rectangle.getUpperLeft().getX() - step, rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newUpperLeft);
        }
        if (rectangle.getUpperLeft().getX() < Consts.BORDER_WIDTH) {
            Point newUpperLeft = new Point(
                    Consts.BORDER_WIDTH, rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newUpperLeft);
        }
    }

    /**
     * Move right.
     * move the paddle one step right.
     */
    public void moveRight() {
        if (rectangle.getUpperLeft().getX() + rectangle.getWidth() < Consts.SCREEN_WIDTH - Consts.BORDER_WIDTH) {
            Point newUpperLeft = new Point(
                    rectangle.getUpperLeft().getX() + step, rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newUpperLeft);
        }
        if (rectangle.getUpperLeft().getX() + rectangle.getWidth() > Consts.SCREEN_WIDTH - Consts.BORDER_WIDTH) {
            Point newUpperLeft = new Point(
                    Consts.SCREEN_WIDTH - Consts.BORDER_WIDTH - rectangle.getWidth(), rectangle.getUpperLeft().getY());
            this.rectangle.setUpperLeft(newUpperLeft);
        }
    }

    @Override
    public void drawOn(DrawSurface d) {
        //rounded edge
        d.setColor(Color.blue);
        d.fillCircle((int) rectangle.getUpperLeft().getX() + Consts.PADDLE_EDGE_RADIUS,
                (int) rectangle.getLeftLine().middle().getY(), Consts.PADDLE_EDGE_RADIUS);
        d.fillCircle((int) rectangle.getUpperLine().getMaxPoint().getX() - Consts.PADDLE_EDGE_RADIUS,
                (int) rectangle.getLeftLine().middle().getY(), Consts.PADDLE_EDGE_RADIUS);
        //rectangle paddle
        d.setColor(color);
        d.fillRectangle((int) rectangle.getUpperLeft().getX() + Consts.PADDLE_EDGE_RADIUS,
                (int) rectangle.getUpperLeft().getY(), (int) rectangle.getWidth() - Consts.PADDLE_HEIGHT,
                (int) rectangle.getHeight());

    }

    @Override
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double regionWidth = rectangle.getWidth() / 5;
        double paddleHeight = rectangle.getUpperLeft().getY();
        Line region1 = new Line(rectangle.getUpperLeft(), rectangle.getUpperLeft().getX() + regionWidth, paddleHeight);
        Line region2 = new Line(region1.end(), region1.end().getX() + regionWidth, paddleHeight);
        Line region3 = new Line(region2.end(), region2.end().getX() + regionWidth, paddleHeight);
        Line region4 = new Line(region3.end(), region3.end().getX() + regionWidth, paddleHeight);
        Line region5 = new Line(region4.end(), region4.end().getX() + regionWidth, paddleHeight);
        Velocity v = currentVelocity;
        double speed = Math.sqrt(v.getDx() * v.getDx() + v.getDy() * v.getDy());
        if (region1.pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(300, speed);
        } else if (region2.pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(330, speed);
        } else if (region3.pointInLine(collisionPoint)) {
            v = new Velocity(v.getDx(), -v.getDy());
        } else if (region4.pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(30, speed);
        } else if (region5.pointInLine(collisionPoint)) {
            v = Velocity.fromAngleAndSpeed(60, speed);
        }
        return v;
    }


    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove from game.
     *
     * @param gameLevel the game level from it the method should to remove the paddle
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * Sets speed.
     *
     * @param speed the new speed of the paddle
     */
    public void setSpeed(int speed) {
        this.step = speed;
    }
}