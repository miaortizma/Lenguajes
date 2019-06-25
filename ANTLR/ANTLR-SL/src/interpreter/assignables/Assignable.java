package interpreter.assignables;

public interface Assignable {
    boolean isAssignable(Object obj);

    void assignIfPossible(Object obj);
}