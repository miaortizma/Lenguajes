package helloAspectJ;

public aspect HelloAspectJ2 {

    pointcut callSayHello(): call(* helloAspectJ.HelloAspectJDemo.sayHello());

    // Advice "after returning".
    // care about the returning value of method
    after() returning (Object retObj): callSayHello() {
        System.out.println("Returned normally with " + retObj);
    }

    after() returning() : callSayHello() {
        System.out.println("Returned normally");
    }

    // or
    // Advice "after returning" not care about the returning value of method
    after() returning : callSayHello() {
        System.out.println("Returned normally");
    }

    // Advice "after throwing".
    after() throwing (Exception e): callSayHello() {
        System.out.println("Threw an exception: " + e);
    }

    // Advice "after returning" + "after throwing".
    after() : callSayHello()  {
        System.out.println("Returned or threw an Exception");
    }
}