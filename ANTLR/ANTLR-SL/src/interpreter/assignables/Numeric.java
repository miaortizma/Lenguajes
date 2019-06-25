package interpreter.assignables;

public class Numeric extends Primitive<Double> {
    public Numeric() {
        super((double) 0);
    }

    public Numeric(Integer ii) {
        super(Double.valueOf(ii));
    }

    public Numeric(Double db) {
        super(db);
    }

    public Numeric(String str) {
        super(Double.parseDouble(str));
    }

    public Integer asInt() {
        if (Math.floor(value) != value || Double.isInfinite(value))
            throw new RuntimeException("Not a integer");
        return value.intValue();
    }

    @Override
    public boolean isAssignable(Object obj) {
        return obj instanceof Numeric;
    }

    @Override
    public void assignIfPossible(Object obj) {
        if (!isAssignable(obj))
            throw new UnsupportedOperationException();
        Numeric aNumeric = (Numeric) obj;
        value = aNumeric.value;
    }
}