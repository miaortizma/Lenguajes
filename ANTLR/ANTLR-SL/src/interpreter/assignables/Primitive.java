package interpreter.assignables;

public abstract class Primitive<T> extends Assignable {
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
