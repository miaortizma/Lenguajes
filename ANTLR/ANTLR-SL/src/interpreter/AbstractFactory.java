package interpreter;

public interface AbstractFactory<T> {

    T build();

    boolean equals(AbstractFactory<T> factory);

}
