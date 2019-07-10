package aspectj.demo07;

public class MyClass {

    public void callA() {

        callB();

        callC();
    }

    public void callB() {

        callC();
    }

    public void callC() {

    }

}
