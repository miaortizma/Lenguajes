package interpreter.assignables;

public interface Comparable<T> {
    boolean greaterThan(T object);

    boolean lessThan(T object);

    boolean greaterOrEqualThan(T object);

    boolean lessOrEqualThan(T object);
}
