package com.plane;

public class Point {
    private double x, y;
    private static String fileName = "points.txt";

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    public static String getFileName() {
        return fileName;
    }
}
