package aspectjdemo01;


public aspect AspectJ01 {

    // Class Point and AspectJ is not the same package
    // so must specify the package (Required).
    // This pointcut definition of JoinPoints
    // only within the class ClassTest01
    // This ClassTest01 and AspectJ same package,
    // so can be ignored package in within(..).
    pointcut callSetX()  : call(void  figures.Point.setX(int)) && within (ClassTest01) ;

    // Advice
    before() : callSetX()  {
        System.out.println("Before call Point.setX(int)");
    }
}

