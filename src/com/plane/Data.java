package com.plane;
import com.plane.Point;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static ArrayList<Point> points = new ArrayList<Point>();

    public static void initFiles() {
        boolean newFl = FileHandler.newDataFile(Point.getFileName());
        if(!newFl) loadPoints();
    }

    public static void addPoint(double x, double y) {
        points.add(new Point(x, y));
    }
    public static void addPoint(Point A) {
        points.add(A);
    }

    public static void savePoint(double x, double y) {
        FileHandler.addLine(Point.getFileName(), x + ", " + y);
        addPoint(x, y);
    }

    public static void loadPoints() {
        List<String> lines = FileHandler.readWholeFile(Point.getFileName());
        int counter = 0;
        for (String ln : lines) {
            String[] arr = ln.split(",", 2);
            addPoint(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
            counter++;
        }
        System.out.println("Loaded " + counter + " points.");
    }

    public static ArrayList<Point> getPointArray() {
        return points;
    }
    public static Point getPointAtPos(int id) { return points.get(id-1); }

    public static void removePoint(int id) {
        points.remove(id-1);
        FileHandler.removeLine(Point.getFileName(), id);
    }

}
