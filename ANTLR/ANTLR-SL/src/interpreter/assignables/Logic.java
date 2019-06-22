package interpreter.assignables;

public class Logic implements Assignable<Logic> {

    private boolean aBoolean;

    public void Logic() { aBoolean = Boolean.FALSE; }

    public void Logic(String str) {
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

    @Override
    public void AssignIfPossible(Logic obj) { this.aBoolean = obj.aBoolean; }
}
