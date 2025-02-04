package ru.ls.qa.school.core;

public class Point {

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private final double x;
    private final double y;

    public double distance(Point point) {
        return Math.sqrt(Math.pow((this.x - point.x), 2)
                + Math.pow((point.y - this.y), 2));
    }
}
