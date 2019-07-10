package aspectj.demo04;

import java.io.PrintStream;

public aspect FieldInAspectJ {

    // Field in AspectJ.
    PrintStream logStream = System.err;

    pointcut move() : call(* figures.Point.move(int,int)) && within(aspectj.demo04.FieldInAspectJTest);

    before(): move() {
        logStream.println("Before Point move");
    }
}