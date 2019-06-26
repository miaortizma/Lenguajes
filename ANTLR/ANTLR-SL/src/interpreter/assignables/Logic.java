package interpreter.assignables;

public class Logic extends Primitive<Boolean> implements Comparable<Logic> {
    public Logic() {
        super(Boolean.FALSE);
    }

    public Logic(Boolean bl) {
        super(bl);
    }

    public Logic(String str) {
        super(str.equals("TRUE") || str.equals("SI"));
    }

    @Override
    public boolean isAssignable(Object obj) {
        return obj instanceof Logic;
    }

    @Override
    public void assignIfPossible(Object obj) {
        if (!isAssignable(obj))
            throw new UnsupportedOperationException();
        Logic aLogic = (Logic) obj;
        value = aLogic.value;
    }

    @Override
    public boolean greaterThan(Logic object) {
        return (value.compareTo(object.value)) > 0;
    }

    @Override
    public boolean lessThan(Logic object) {
        return (value.compareTo(object.value)) < 0;
    }

    @Override
    public boolean greaterOrEqualThan(Logic object) {
        return (value.compareTo(object.value)) >= 0;
    }

    @Override
    public boolean lessOrEqualThan(Logic object) {
        return (value.compareTo(object.value)) <= 0;
    }
}
