package geometry;

/**
 * The type geometry.Velocity.
 * geometry.Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Instantiates a new geometry.Velocity.
     *
     * @param dx the dx (symbol of small change of the x coordinate).
     * @param dy the dy (symbol of small change of the y coordinate).
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Instantiates a new geometry.Velocity.
     *
     * @param v the velocity
     */
    public Velocity(Velocity v) {
        this.dx = v.dx;
        this.dy = v.dy;
    }

    /**
     * From angle and speed velocity.
     * change the velocity terms from angle and speed to dx and dy
     *
     * @param angle the angle of the ball movement
     * @param speed the speed of the ball movement
     * @return the velocity after the changes
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        //change the angle from degrees to radians.
        angle = Math.toRadians(angle);
        // change to dx and dy therms, notice the t axis is reversed.
        double dx = speed * Math.sin(angle);
        double dy = -speed * Math.cos(angle);
        //return the new velocity.
        return new Velocity(dx, dy);
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return dx;
    }


    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return dy;
    }

    /**
     * Apply point to point.
     * Take a point with position (x,y) and return a new point with position (x+dx, y+dy)
     *
     * @param p the shapes.Point the method need to change.
     * @return the point after the change.
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}