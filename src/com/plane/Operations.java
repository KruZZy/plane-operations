package com.plane;
import com.plane.Data;
import java.util.Scanner;

public class Operations {

    private static final int OP_EXIT = 0,
            OP_ADD_POINT = 1,
            OP_REM_POINT = 2,
            OP_LIST_POINTS = 3;

    public static final String[] names = {
            "0. Exit",
            "1. Add a new point",
            "2. Remove a point (by ID. use 3.)",
            "3. List points"
    };

    static Scanner kbScan = new Scanner(System.in);

    public static int execute(int operation) {
        switch(operation) {
            case OP_ADD_POINT: return addPoint();
            case OP_REM_POINT: return removePoint();
            case OP_LIST_POINTS: return listPoints();
        }
        return OP_EXIT;
    }

    private static int addPoint() {
        double x, y;
        System.out.print("\nGive x coordinate: ");
        x = kbScan.nextDouble();
        System.out.print("\nGive y coordinate: ");
        y = kbScan.nextDouble();

        Data.addPoint(x, y);
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
}