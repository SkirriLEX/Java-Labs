package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<MyTriangle> mt = new HashSet<>();
        mt.add(new MyTriangle(new Point(-3.0, -2.0), new Point(0, -1), new Point(-2, 5)));
        mt.add(new MyTriangle(new Point(0, 0), new Point(4.0, 0), new Point(2, 5.0)));
        mt.add(new MyTriangle(new Point(13.0, 20), new Point(13.0, 6.5), new Point(4.0, 0)));
        helpShowAllTriangle(mt);
    }

    public static void helpShowAllTriangle(HashSet<MyTriangle> myTriangles) {
        int i = 1;
        for (MyTriangle mt : myTriangles) {
            System.out.println("\nTriangle_" + i++ + "________");
            System.out.printf("point A :(%.3f,%.3f)\n", mt.getPointOne().x, mt.getPointOne().y);
            System.out.printf("point B :(%.3f,%.3f)\n", mt.getPointTwo().x, mt.getPointTwo().y);
            System.out.printf("point C :(%.3f,%.3f)\n", mt.getPointThree().x, mt.getPointThree().y);
            System.out.println("Status :" + mt.getTriangleStatus().toString());
        }
    }
}