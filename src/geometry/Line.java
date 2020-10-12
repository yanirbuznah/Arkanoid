package geometry;

import java.util.List;

/**
 * The type shapes.Line.
 * This shapes.Line represents a line segment in (x,y) coordinate space by using two points.
 */
public class Line {
    private static final double EPSILON = 1.0E-5;
    private Point start;
    private Point end;

    /**
     * Instantiates a new shapes.Line.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;

    }

    /**
     * Instantiates a new shapes.Line.
     *
     * @param x1 the x 1 (x coordinate of the start of the line).
     * @param y1 the y 1 (y coordinate of the start of the line).
     * @param x2 the x 2 (x coordinate of the end of the line).
     * @param y2 the y 2 (x coordinate of the end of the line).
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * Instantiates a new shapes.Line.
     *
     * @param start the start point of the line
     * @param x2 the x 2 (x coordinate of the end of the line).
     * @param y2 the y 2 (x coordinate of the end of the line).
     */
    public Line(Point start, double x2, double y2) {
        this.start = start;
        this.end = new Point(x2, y2);
    }

    /**
     * Length double.
     *
     * @return the double - length of the line.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * Middle point.
     *
     * @return the shapes.Point - middle point of the line.
     */
    public Point middle() {
        double middleX = (start.getX() + end.getX()) / 2;
        double middleY = (start.getY() + end.getY()) / 2;
        return new Point(middleX, middleY);
    }

    /**
     * Start point.
     *
     * @return the shapes.Point - start point of the line.
     */
    public Point start() {
        return start;
    }

    /**
     * End point.
     *
     * @return the shapes.Point - end point of the line.
     */
    public Point end() {
        return end;
    }

    /**
     * shapes.Point in this line boolean.
     *
     * @param a the point to check (if the point in the line or not).
     * @return the boolean (true) if the point in the line and false otherwise.
     */
    public boolean pointInLine(Point a) {
        double lineLength = start.distance(a) + end.distance(a);
        return Math.abs(lineLength - length()) < EPSILON;
    }

    /**
     * Gets min point. get the shapes.Point with the minimum value of the x coordinates in the line.
     *
     * @return the shapes.Point with the min x coordinate of the line.
     */
    public Point getMinPoint() {
        if (start.getX() > end.getX()) {
            return this.end;
        }
        return this.start;
    }

    /**
     * Gets max point. get the shapes.Point with the maximum value of the x coordinates in the line.
     *
     * @return the shapes.Point with the max x coordinate of the line.
     */
    public Point getMaxPoint() {
        if (start.getX() > end.getX()) {
            return this.start;
        }
        return this.end;
    }

    /**
     * Continue lines point. Checks whether the lines continue with each other at exactly the same point.
     *
     * @param other the other line
     * @return the point of the connecting (the intresection point).
     */
    public Point continueLines(Line other) {
        if (this.getMaxPoint().equals(other.getMinPoint())) {
            return this.getMaxPoint();
        }
        if (this.getMinPoint().equals(other.getMaxPoint())) {
            return this.getMinPoint();
        }
        return null;
    }

    /**
     * Intersection point.
     * The method check if two lines intersect (infinity lines), by using Cramer's rule.
     *
     * @param other the other line with which the method checks for intersection.
     * @return the shapes.Point - Intersection point, and null if the lines is not intersect.
     */
    public Point intersectionPoint(Line other) {
        //the variables of Carmer's rule.
        double a = other.start.getY() - other.end.getY();
        double b = other.start.getX() - other.end.getX();
        double c = this.start.getY() - this.end.getY();
        double d = this.start.getX() - this.end.getX();
        double e = other.start.getX() * other.end.getY() - other.start.getY() * other.end.getX();
        double f = this.start.getX() * this.end.getY() - this.start.getY() * this.end.getX();
        //the determinant of the 2X2 matrix.
        double determinant = a * d - b * c;
        // if the determinant are 0 the lines do not intersect with each other or they continues each other.
        if (determinant == 0) {
            return continueLines(other);
        }
        // if the lines do intersect, calculate the intersection point
        double x = (b * f - e * d) / determinant;
        double y = (a * f - e * c) / determinant;
        return new Point(x, y);

    }

    /**
     * Is intersecting boolean.
     *
     * @param other the other line with which the method checks for intersection.
     * @return the boolean - true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        Point intersectionP;
        // if one of the lines start and end in the same point (so its actually a point) check this point.
        if (this.start.equals(this.end)) {
            intersectionP = this.start;
        } else if (other.start.equals(other.end)) {
            intersectionP = other.start;
        } else {
            intersectionP = intersectionPoint(other);
        }
        // return true if the intersection point is not null and the intersection in the range of the line segment
        return intersectionP != null && pointInLine(intersectionP) && other.pointInLine(intersectionP)
                && !equals(other);
    }

    /**
     * Intersection with point.
     *
     * @param other the other line with which the method checks for intersection.
     * @return the shapes.Point - Intersection point, and null if the lines is not intersect.
     */

    public Point intersectionWith(Line other) {
        // check if the lines intersect and return the intersection point if they are.
        if (isIntersecting(other)) {
            return intersectionPoint(other);
        }
        return null;
    }

    /**
     * Equals boolean.
     *
     * @param other the other line with which the method checks for equality
     * @return the boolean - true is the lines are equal, false otherwise
     */
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    /**
     * Closest intersection to start of line point.
     * check if the line intersect with the given rectangle .
     * return the closet interaction point to the start of the line.
     *
     * @param rect the given rectangle
     * @return shapes.Point - the closet intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        //list of the intersections points of the rectangle.
        List<Point> points = rect.intersectionPoints(this);
        if (points.isEmpty()) {
            return null;
        }
        if (points.size() == 1) {
            return points.get(0);
        }
        //straight line can intersect with rectangle at most 2 times, check and return the closet point of the 2.
        if (points.get(0).distance(this.start) > points.get(1).distance(this.start)) {
            return points.get(0);
        }
        return points.get(1);
    }
}
