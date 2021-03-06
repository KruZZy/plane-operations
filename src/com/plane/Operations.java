package com.plane;
import com.plane.Data;
import java.util.Scanner;
import java.lang.Math;

public class Operations {

    private static double EPS = 1e-10;

    private static final int
            OP_EXIT = 0,
            OP_ADD_POINT = 1,
            OP_REM_POINT = 2,
            OP_LIST_POINTS = 3,
            OP_DIST_POINTS = 4,
            OP_COLLIN_POINTS = 5;


    public static final String[] names = {
            "0. Exit",
            "1. Add a new point",
            "2. Remove a point (by ID. use 3.)",
            "3. List points",
            "4. Get distance between points (by IDs. use 3.)",
            "5. Determine if 3 points are collinear (by IDs. use 3.)"
    };

    static Scanner kbScan = new Scanner(System.in);

    public static int execute(int operation) {
        switch(operation) {
            case OP_ADD_POINT: return addPoint();
            case OP_REM_POINT: return removePoint();
            case OP_LIST_POINTS: return listPoints();
            case OP_DIST_POINTS: return getPointDist();
            case OP_COLLIN_POINTS: return arePointsCollin();
        }
        return OP_EXIT;
    }

    private static int addPoint() {
        double x, y;
        System.out.print("Give x coordinate: ");
        x = kbScan.nextDouble();
        System.out.print("Give y coordinate: ");
        y = kbScan.nextDouble();
        Point A = new Point(x, y);
        Data.savePoint(x, y);
        return 1;
    }

    private static int listPoints() {
        int ord = 1;
        for(Point A : Data.getPointArray())
            System.out.println((ord++) + ") x = " + A.getX() + "; y = " + A.getY());
        return 1;
    }

    private static int removePoint() {
        System.out.print("Give point ID: ");
        int id = Operations.kbScan.nextInt();

        Data.removePoint(id);
        return 1;
    }

    private static int getPointDist() {
        System.out.print("First point ID: ");
        int p_1 = kbScan.nextInt();
        System.out.print("Second point ID: ");
        int p_2 = kbScan.nextInt();

        Point p1 = Data.getPointAtPos(p_1);
        Point p2 = Data.getPointAtPos(p_2);
        double xDiff = p2.getX() - p1.getX(),
               yDiff = p2.getY() - p1.getY();

        xDiff *= xDiff;
        yDiff *= yDiff;

        double distance = Math.sqrt(xDiff + yDiff);
        System.out.println("Distance: " + distance);
        return 1;
    }

    private static int arePointsCollin() {
        Point[] p = new Point[3];
        for(int i = 1; i <= 3; i++) {
            System.out.print("Give ID of point " + i + ": ");
            int id = kbScan.nextInt();
            p[i-1] = Data.getPointAtPos(id);
        }
        Matrix D = new Matrix(3, 3);
        D.populateWithPoints(p);

        if(Math.abs(D.determinant()) <= EPS) System.out.println("The three points are collinear.");
        else System.out.println("The three points are NOT collinear.");
        return 1;
    }
}