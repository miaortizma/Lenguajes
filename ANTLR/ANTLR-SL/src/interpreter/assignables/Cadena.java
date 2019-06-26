package interpreter.assignables;

public class Cadena extends Primitive<String> implements Comparable<Cadena> {
    public Cadena() {
        super("");
    }

    public Cadena(String str) {
        super(str.replaceAll("\"", ""));
    }

    public Cadena(Character chr) {
        super(chr.toString());
    }

    public Cadena charAt(int i) {
        if (!(1 <= i && i <= value.length()))
            return new Cadena(value.charAt(i - 1));
        throw new RuntimeException();
    }

    @Override
    public boolean isAssignable(Object obj) {
        return obj instanceof Cadena;
    }

    @Override
    public void assignIfPossible(Object obj) {
        if (!isAssignable(obj))
            throw new UnsupportedOperationException();
        Cadena aCadena = (Cadena) obj;
        value = aCadena.value;
    }

    @Override
    public boolean greaterThan(Cadena object) {
        return value.compareTo(object.value) > 0;
    }

    @Override
    public boolean lessThan(Cadena object) {
        return value.compareTo(object.value) < 0;
    }

    @Override
    public boolean greaterOrEqualThan(Cadena object) {
        return value.compareTo(object.value) >= 0;
    }

    @Override
    public boolean lessOrEqualThan(Cadena object) {
        return value.compareTo(object.value) <= 0;
    }
}
