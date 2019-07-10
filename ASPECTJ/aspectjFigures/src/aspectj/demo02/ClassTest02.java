package aspectj.demo02;

import figures.Point;

public class ClassTest02 {

    public static void main(String[] args) {

        Point point = new Point(10, 200);

        System.out.println("---- (1) ----");

        point.move(20, 30);

        System.out.println("---- (2) ----");

        System.out.println(point.toString());

        System.out.println("---- (3) ----");

        point.setX(100);
    }

}