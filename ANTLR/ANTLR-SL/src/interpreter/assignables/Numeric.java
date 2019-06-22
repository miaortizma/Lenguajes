package interpreter.assignables;

public class Numeric implements Assignable<Numeric> {

    private double aDouble;

    public Numeric() { aDouble = Double.parseDouble("0"); }

    public Numeric(String str) { aDouble = Double.parseDouble(str); }

    @Override
    public void AssignIfPossible(Numeric obj) {
        aDouble = obj.aDouble;
    }
}