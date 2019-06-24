package interpreter.assignables;

public class Cadena implements Assignable {

    private String str;

    public Cadena() { str = ""; }

    public Cadena(String str) { this.str = str; }

    public Cadena(Character chr) { this.str = ""+chr; }

    public String get() { return str; }

    public Cadena charAt(int i) {
        if(!(1 <= i && i <= str.length()))
            return new Cadena(str.charAt(i - 1));

        throw new RuntimeException();
    }

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
