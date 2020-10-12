package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * The type shapes.Rectangle.
 * Implementation of a rectangle object,with the upper left point, the height and the width.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;


    /**
     * Instantiates a new shapes.Rectangle.
     *
     * @param upperLeft the upper left point of the rectangle.
     * @param width     the width of the rectangle.
     * @param height    the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;


    }

    /**
     * Intersection points list.
     * check and return a (possibly empty) List of intersection points with the given line.
     *
     * @param line the line with which the method checks for intersections.
     * @return the list of the intersections points.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> points = new ArrayList<Point>();
        if (line.isIntersecting(getUpperLine())) {
            points.add(line.intersectionPoint(getUpperLine()));
        }
        if (line.isIntersecting(getLowerLine())) {
            points.add(line.intersectionPoint(getLowerLine()));
        }
        if (line.isIntersecting(getRightLine())) {
            points.add(line.intersectionPoint(getRightLine()));
        }
        if (line.isIntersecting(getLeftLine())) {
            points.add(line.intersectionPoint(getLeftLine()));
        }
        return points;
    }

    /**
     * Gets width.
     *
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets height.
     *
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets upper left.
     *
     * @return shapes.Point  - the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Sets upper left.
     * set the new upper left point of the rectangle.
     *
     * @param upperLeftPoint the new upper left point
     */
    public void setUpperLeft(Point upperLeftPoint) {
        this.upperLeft = upperLeftPoint;
    }

    /**
     * Gets left line.
     *
     * @return the left line of the rectangle.
     */
    public Line getLeftLine() {
        return new Line(upperLeft, upperLeft.getX(), upperLeft.getY() + height);
    }
    /**
     * Gets lower line.
     *
     * @return the lower line of the rectangle.
     */
    public Line getLowerLine() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowerRight = new Point(upperRight.getX(), upperRight.getY() + height);
        return new Line(lowerRight, upperLeft.getX(), upperLeft.getY() + height);
    }

    /**
     * Gets right line.
     *
     * @return the right line of the rectangle.
     */
    public Line getRightLine() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point lowerRight = new Point(upperRight.getX(), upperRight.getY() + height);
        return new Line(upperRight, upperRight.getX(), upperRight.getY() + height);
    }

    /**
     * Gets upper line.
     *
     * @return the upper line of the rectangle.
     */
    public Line getUpperLine() {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        return new Line(upperLeft, upperRight);
    }

}
