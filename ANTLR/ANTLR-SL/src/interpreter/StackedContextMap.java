package interpreter;

import java.util.HashMap;
import java.util.Vector;
import gen.SLParser.SubrutinaContext;

class Reference {

    int level;

    public Reference(int level) {
        this.level = level;
    }

}


public class StackedContextMap {


    private Vector<HashMap<String, Object> > stack;


    public StackedContextMap() {
        this.stack = new Vector<>();
        stack.add(new HashMap<>());
    }


    public HashMap<String, Object> getGlobalContext() {
        return this.stack.elementAt(0);
    }

    public HashMap<String, Object> getContext() {
        return this.stack.elementAt(this.stack.size() - 1);
    }

    public HashMap<String, Object> getContextAt(int index) { return this.stack.elementAt(index); }

    public void put(String str, Object obj) {
        this.getContext().put(str, obj);
    }

    public Object get(String str) {
        Object obj = this.getContext().get(str);
        if(obj == null) throw new IllegalArgumentException("Variable doesn't exists");

        if(obj instanceof Reference) {
            return this.getReference(str, (Reference) obj);
        }
        return obj;
    }

    /*
    Takes variable last context and passes it as reference to current level
     */
    public void putReference(String str) {
        // if variable to reference is a reference in last context
        int level = this.size() - 2;
        Object referenced = this.getContextAt(level).get(str);
        if(referenced == null)  throw new IllegalArgumentException("Referenced variable doesn't exists");

        if(referenced instanceof Reference ){
            this.put(str, referenced);
        }else {
            this.put(str, new Reference(level));
        }
    }

    private Object getReference(String str, Reference ref) {
        return this.getContextAt(ref.level).get(str);
    }

    public boolean isFunc(String str) {
        HashMap context = this.getContext();
        return (context.containsKey(str) && ( context.get(str) instanceof  SubrutinaContext ) );
    }



    public void pop() {
        if(this.size() == 1) throw new IllegalArgumentException("Can't pop Global context!");

        this.stack.removeElementAt(this.stack.size() - 1);
    }


    public void push() {
        // New Context copy of global context
        this.stack.add(new HashMap<>(this.getGlobalContext()));
    }

    public int size() { return this.stack.size(); }
}
