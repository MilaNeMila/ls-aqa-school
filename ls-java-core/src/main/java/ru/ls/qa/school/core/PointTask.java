package ru.ls.qa.school.core;

public class PointTask {
    public static void main(String[] args) {
        Point pointA = new Point(1, 2);
        Point pointB = new Point(2, 3);
        System.out.println("Check the answer: " + pointA.distance(pointB));
    }
}