package interpreter;

public interface Assignable<T> {

    public boolean IsAssignable(Object obj);

    public boolean Assign(T obj);
}