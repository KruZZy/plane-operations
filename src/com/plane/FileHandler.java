package com.plane;
import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
public class FileHandler {
    private static Scanner scanner;

    public static boolean newDataFile(String fileName) {
        try {
            File tmp = new File(fileName);

            if (tmp.createNewFile())
                System.out.println("New data file created: " + fileName);
            return tmp.createNewFile();
        } catch(IOException e) {
            System.out.println("There was an error creating " + fileName);
            e.printStackTrace();
        }

        return false;
    }

    public static void addLine(String fl, String ln) {
        try {
            FileWriter wrt = new FileWriter(fl, true);
            wrt.write(ln + '\n');
            wrt.flush();
            wrt.close();
        } catch (IOException e) {
            System.out.println("An error occured when writing to " + fl);
            e.printStackTrace();
        }
    }

    public static List<String> readWholeFile(String fl) {
        try {
            return Files.readAllLines(Path.of(fl), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("An error occured when reading " + fl);
            e.printStackTrace();
        }

        return null;
    }

    public static void removeLine(String fl, int ind) {
        try {
            List<String> lns = readWholeFile(fl);
            FileWriter wrt = new FileWriter(fl, false);

            int cnt = 1;
            for (String s : lns) {
                if (cnt != ind)
                    wrt.write(s + '\n');
                cnt++;
            }
            wrt.flush();
            wrt.close();
        } catch (IOException e) {
            System.out.println("An error occured when removing line from " + fl);
            e.printStackTrace();
        }
    }
}
