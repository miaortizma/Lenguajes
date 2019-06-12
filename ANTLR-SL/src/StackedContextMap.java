import java.util.HashMap;
import java.util.Vector;

public class StackedContextMap {


    Vector<HashMap> stack;
    HashMap<String, Object> table;


    public StackedContextMap() {
        this.table = new HashMap<>();
        this.stack = new Vector<>(table);
    }


    public HashMap getGlobalContext() {
        return this.stack.elementAt(0);
    }


    public HashMap getContext() {
        return this.stack.elementAt(this.stack.size() - 1);
    }

    public void put(String str, Object obj) {
        // to-do handle referenced variable
        this.getContext().put(str, obj);
    }

    public Object get(String str) {
        // to-do handle references
        HashMap context = this.getContext();
        return context.get(str);
    }

    public void pop() {
        if(this.size() > 1){
            this.stack.removeElementAt(this.stack.size() - 1);
        }else {
            System.out.println("Can't pop Global context");
        }
    }

    public int size() {
        return this.stack.size();
    }

    public void push() { // to do
        // override global references

    }

    // to-do create HashMap from parameters




}
