package aspectj.demo07;


public aspect CFlowAspectJ {

    pointcut call_cflow_callA() :  cflow( call( * aspectj.demo07.MyClass.callA() ) )  && within(aspectj.demo07.CFlowDemo || aspectj.demo07.MyClass);

    before() : call_cflow_callA()  {
        System.out.println(
                "Join Point at: " + thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName()
                        + " --> " + thisJoinPointStaticPart.getSourceLocation().getLine());
    }

}