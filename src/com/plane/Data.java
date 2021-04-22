package com.plane;
import com.plane.Point;
import java.util.ArrayList;

public class Data {
    private static ArrayList<Point> points = new ArrayList<Point>();

    public static void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }

    public static ArrayList<Point> getPointArray() {
        return points;
    }

    public static void removePoint(int id) {
        points.remove(id-1);
    }
}
