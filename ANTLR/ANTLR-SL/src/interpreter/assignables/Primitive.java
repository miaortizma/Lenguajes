package interpreter.assignables;

public abstract class Primitive<T> implements Assignable {
    T value;

    Primitive(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
