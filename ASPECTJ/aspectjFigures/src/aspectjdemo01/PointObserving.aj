package aspectjdemo01;

import java.util.ArrayList;
import java.util.List;

import figures.Point;

public aspect PointObserving {

    // Class Point have no field: observers
    // However, it can declare here.
    // observers: Store the change point position.
    private List<Point> Point.observers = new ArrayList<Point>();

    pointcut moveAction(Point point) : call(void Point.move(int,int) )
            && target(point)
            && within(PointObservingTest);

    after(Point point) : moveAction(point)  {
        System.out.println("Point moved");
        // add new position
        point.observers.add(point);

        // Print the location of the point went through.
        System.out.println(" - "+point.observers);
    }

    public static void addObserver(Point p) {
        // p.observers.add(s);
    }

    public static void removeObserver(Point p) {
        // p.observers.remove(s);
    }
}