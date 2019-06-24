package interpreter.assignables;

public class Logic implements Assignable {
    private boolean aBoolean;

    public Logic() {
        aBoolean = Boolean.FALSE;
    }

    public Logic(String str) {
        switch (str) {
            case "TRUE":
            case "SI":
                aBoolean = Boolean.TRUE;
                break;
            case "FALSE":
            case "NO":
                aBoolean = Boolean.FALSE;
        }
    }

    public boolean get() {
        return aBoolean;
    }

    @Override
    public boolean IsAssignable(Object obj) {
        return obj instanceof Logic;
    }

    @Override
    public void AssignIfPossible(Object obj) {
        if (!IsAssignable(obj))
            throw new UnsupportedOperationException();
        Logic aLogic = (Logic) obj;
        aBoolean = aLogic.aBoolean;
    }
}
