package interpreter.factories;

import interpreter.assignables.Assignable;

public interface AbstractFactory<T extends Assignable> {
    T build();

    boolean equals(AbstractFactory<T> factory);
}
