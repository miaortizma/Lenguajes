package interpreter.assignables;

public interface Assignable {

    boolean IsAssignable(Object obj);

    void AssignIfPossible(Object obj);


}