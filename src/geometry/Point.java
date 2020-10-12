package geometry;

/**
 * The type shapes.Point.
 * A point representing a location in (x,y) coordinate space, specified in double precision.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Construct a point given x and y coordinates.
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * measure the distance between two point by using the formula: square root of: ((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)).
     *
     * @param other a point to measure the distance to
     * @return the double - the distance of this point to the other point
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }


    /**
     * Equals boolean.
     *
     * @param other the other shapes.Point
     * @return the boolean  (True) if the points are the same and false otherwise
     */
    public boolean equals(Point other) {
        return this.x == other.getX() && this.y == other.getY();
    }

    /**
     * @return the x coordinate
     */
    public double getX() {
        return this.x;
    }

    /**
     * Sets x.
     *
     * @param newX the new x coordinate of the point.
     */
    public void setX(double newX) {
        this.x = newX;
    }

    /**
     * @return the y coordinate
     */
    public double getY() {
        return this.y;
    }

    /**
     * Sets y.
     *
     * @param newY the new y coordinate of the point.
     */
    public void setY(double newY) {
        this.y = newY;
    }

    public static void printt(){
        System.out.println("x");
    }
}

