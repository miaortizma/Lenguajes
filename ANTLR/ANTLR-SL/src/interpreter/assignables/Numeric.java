package interpreter.assignables;

public class Numeric implements Assignable {

    private double aDouble;

    public Numeric() { aDouble = Double.parseDouble("0"); }

    public Numeric(String str) { aDouble = Double.parseDouble(str); }

    public Numeric(Integer value) { aDouble = Double.valueOf((double) value); }

    public Numeric(Double value) { aDouble = Double.valueOf(value); }

    public double get() { return aDouble; }

    public int asInt() {
        if((int) aDouble != aDouble)
            throw new RuntimeException("Not a integer");
        return (int) aDouble;
    }

    @Override
    public boolean IsAssignable(Object obj) { return obj instanceof Numeric; }

    @Override
    public void AssignIfPossible(Object obj) {
        if(!IsAssignable(obj))
            throw new UnsupportedOperationException();
        Numeric aNumeric = (Numeric) obj;
        aDouble = aNumeric.aDouble;
    }
}