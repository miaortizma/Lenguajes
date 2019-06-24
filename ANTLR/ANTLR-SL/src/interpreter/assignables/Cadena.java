package interpreter.assignables;

public class Cadena implements Assignable {

    private String str;

    public Cadena() { str = ""; }

    public Cadena(String str) { this.str = str; }

    public String get() { return str; }

    @Override
    public boolean IsAssignable(Object obj) { return obj instanceof String; }

    @Override
    public void AssignIfPossible(Object obj) {
        if(!IsAssignable(obj))
            throw new UnsupportedOperationException();
        Cadena aCadena = (Cadena) obj;
        str = aCadena.str;
    }

}
