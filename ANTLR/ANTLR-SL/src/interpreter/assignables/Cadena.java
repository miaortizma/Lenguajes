package interpreter.assignables;

public class Cadena implements Assignable<Cadena> {

    private String str;

    public Cadena() { str = new String(); }

    public void AssignIfPossible(Cadena obj) { str = obj.str; }

}
