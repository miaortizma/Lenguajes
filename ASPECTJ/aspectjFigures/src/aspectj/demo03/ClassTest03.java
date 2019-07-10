package aspectj.demo03;

import figures.FigureElement;
import figures.Line;
import figures.Point;

public class ClassTest03 {
    public static void main(String[] args) {

        Point point = new Point(10, 200);

        System.out.println("---- (1) ----");

        point.setX(20 );

        System.out.println("---- (2) ----");

        FigureElement line= new Line(new Point(1,1), new Point(10,10));

        line.move(10, 10);

        System.out.println("---- (3) ----");
    }
}