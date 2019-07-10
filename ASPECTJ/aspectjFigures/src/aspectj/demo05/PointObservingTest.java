package aspectj.demo05;

import figures.Point;

public class PointObservingTest {

    public static void main(String[] args) {

        Point point1 = new Point(100, 100);

        // First move
        point1.move(10, 10);

        // Second move
        point1.move(10, 10);

        System.out.println("----------------------");

        Point point2 = new Point(200, 200);

        // First move
        point2.move(15, 10);

        // Second move
        point2.move(15, 10);

        // Third Move
        point2.move(25, 10);
    }
}