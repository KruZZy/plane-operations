package com.plane;


public class Main {
    public static void main(String[] args) {
        Data.initFiles();

        System.out.print("Welcome! Choose an operation:");
        for(String name : Operations.names) System.out.println(name);

        int op = Operations.kbScan.nextInt();
        int result;
        do {
            result = Operations.execute(op);
            System.out.print("\nGive new operation: ");
            op = Operations.kbScan.nextInt();
        } while (op != 0);
    }
}
