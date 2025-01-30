package ru.ls.qa.school.core;

public class Point {

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
    private final double x;
    private final double y;
    
    public double distance(Point point){
        return Math.sqrt(((this.x-point.x)*(this.x-point.x))
                +((point.y-this.y)*(point.y-this.y)));
    }
}
