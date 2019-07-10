package helloAspectJ;

public aspect HelloAspectJ {

    // Define a Pointcut is
    // collection of JoinPoint call sayHello of class HelloAspectJDemo.
    pointcut callSayHello(): call(* helloAspectJ.HelloAspectJDemo.sayHello());

    // This Means that everywhere (class, AspectJ) called SayHello()
    //pointcut callSayHello(): call(* * .sayHello())

    before() : callSayHello() {
        System.out.println("Before call sayHello");
    }

    after() : callSayHello()  {
        System.out.println("After call sayHello");
    }


}