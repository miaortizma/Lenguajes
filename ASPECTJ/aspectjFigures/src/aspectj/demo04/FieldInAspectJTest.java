package aspectj.demo04;

import figures.Point;

public class FieldInAspectJTest {

    public static void main(String[] args) {

        Point point = new Point(10, 200);

        System.err.println("---- (1) ----");

        point.setX(20);

        System.err.println("---- (2) ----");

        point.move(10, 10);

        System.err.println("---- (3) ----");
    }
}