package interpreter.assignables;

public abstract class Assignable implements SubroutineReturn {
    public abstract boolean isAssignable(Object obj);

    public abstract void assignIfPossible(Object obj);
}