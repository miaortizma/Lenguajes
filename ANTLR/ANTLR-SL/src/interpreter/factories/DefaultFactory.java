package interpreter.factories;

import interpreter.assignables.Assignable;

import java.lang.reflect.Constructor;

public class DefaultFactory<T extends Assignable> implements AbstractFactory<T> {

    private final Constructor<T> ctor;

    public DefaultFactory(Class<T> clss) {
        try {
            ctor = clss.getConstructor();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public T build() {
        try {
            return ctor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public boolean equals(AbstractFactory factory) {
        if (factory instanceof DefaultFactory) {
            DefaultFactory df = (DefaultFactory) factory;
            return ctor.equals(df.ctor);
        }
        return false;
    }
}
