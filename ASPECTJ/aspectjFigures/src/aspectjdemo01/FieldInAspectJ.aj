package aspectjdemo01;

import java.io.PrintStream;

public aspect FieldInAspectJ {

    // Field in AspectJ.
    PrintStream logStream = System.err;

    pointcut move() : call(* figures.Point.move(int,int)) && within(FieldInAspectJTest);

    before(): move() {
        logStream.println("Before Point move");
    }
}