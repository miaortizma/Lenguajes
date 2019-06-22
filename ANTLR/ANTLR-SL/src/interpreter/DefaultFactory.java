package interpreter;

import java.lang.reflect.Constructor;

public class DefaultFactory<T> implements AbstractFactory<T> {

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
        return ctor.equals(factory.);
    }

}
