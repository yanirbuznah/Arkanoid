package sprites;

import animation.GameLevel;
import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import geometry.Velocity;
import listeners.HitListener;
import listeners.HitNotifier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The type sprites.Block.
 * Implementation of a block object,with rectangle shape and color.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners = new ArrayList<HitListener>();
    private Rectangle rectangle;
    private Color color;

    /**
     * The constructor of the sprites.Block.
     *
     * @param rect  the rectangle shape of the block.
     * @param color the color of the block.
     */
    public Block(Rectangle rect, Color color) {
        this.rectangle = rect;
        this.color = color;
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }


    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());


    }


    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * Remove the block from the game.
     *
     * @param gameLevel the game.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeCollidable(this);
        gameLevel.removeSprite(this);
    }


    /**
     * Notify hit.
     * Notify all listeners about a hit event.
     *
     * @param hitter the hitter ball.
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }


    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity v = currentVelocity;
        //change the velocity according the hit point in the block
        if (rectangle.getUpperLine().pointInLine(collisionPoint)
                || rectangle.getLowerLine().pointInLine(collisionPoint)) {
            v = new Velocity(v.getDx(), -v.getDy());
        }
        if (rectangle.getLeftLine().pointInLine(collisionPoint)
                || rectangle.getRightLine().pointInLine(collisionPoint)) {
            v = new Velocity(-v.getDx(), v.getDy());
        }
        this.notifyHit(hitter);
        return v;
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }


}