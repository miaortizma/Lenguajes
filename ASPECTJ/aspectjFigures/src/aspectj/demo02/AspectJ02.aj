package aspectj.demo02;

// Ready import Point class.
import figures.Point;

public aspect AspectJ02 {


    // Using target: define object on which the method is called
    // Using args: define args on the method is called
    // Using within: to restrict JoinPoint within ClassTest02
    pointcut callMove(Point point, int dx, int dy)
            : call(*  figures.Point.move(int,int))
            && args(dx,dy) && target(point) && within(aspectj.demo02.ClassTest02)  ;

    before(Point point, int dx, int dy) : callMove(point,  dx, dy )  {
        System.out.println("Before call move(" + dx + "," + dy + ")");
        System.out.println(point.toString());
    }
}