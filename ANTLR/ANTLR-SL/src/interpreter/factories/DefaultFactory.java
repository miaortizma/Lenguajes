package interpreter.factories;

import interpreter.assignables.Assignable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DefaultFactory<T extends Assignable> implements AbstractFactory<T> {

    private final Constructor<T> ctor;
    private final Class<T> clss;

    public DefaultFactory(Class<T> clss) {
        try {
            this.clss = clss;
            ctor = clss.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cannot find the class constructor for " + clss.getCanonicalName());
        }
    }

    public T build() {
        try {
            return ctor.newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Cannot initializate the class " + ctor.getName());
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

    public Class<T> getClss() { return clss; }
}
