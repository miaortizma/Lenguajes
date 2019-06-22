package interpreter;

import java.util.HashMap;
import java.util.Vector;

/**
 * read-only
 */
private class Const {

    private Object maskedInstance;

    public Const(Object maskedInstance) {
        this.maskedInstance = maskedInstance;
    }

    public Object get() { return this.maskedInstance; }

}

private class Reference {

    int level;

    public Reference(int level) { this.level = level; }

}



/**
 * Function to manage a stacked context which supports:
 * - vertical (push, pop) and horizontal (put, get) context
 * - const elements ( immutable )
 * - referenced elements ( to lower parts of the stack )
 * - no more
 * @author miaortizma
 */
public class StackedContextMap {



    private Vector<HashMap<String, Object>> stack;
    private HashMap<String, Object> globalContext, context;


    public StackedContextMap() {
        this.stack = new Vector<>();
        this.globalContext = new HashMap<>();
        this.context = globalContext;
        stack.add(this.globalContext);
    }

    private HashMap<String, Object> getContextAt(int index) {
        if(index < 0 || index > this.size() - 1) throw new IndexOutOfBoundsException();
        return this.stack.elementAt(index);
    }

    /**
     * Places nextObj if possible into current context, which may be global context.
     * @param str
     * @param nextObj
     */
    public void put(String str, Object nextObj) throws IllegalAccessException {
        //Explore invalid options
        if(in(this.context, str)) {
            Object res = this.getUnresolvedConst(str);
            if(res instanceof Const)
                throw new IllegalAccessException("Const identifier");
            else
                DefaultAssigner.AssignIfPossible(res, nextObj);
        }
        this.context.put(str, nextObj);
    }

    /**
     *
     * @param str
     * @return res
     */
    private Object getUnresolvedConst(String str) {
        Object res;
        if(in(context, str))
            res = context.get(str);
        else if(in(globalContext, str))
            res = globalContext.get(str);
        else
            throw new IllegalArgumentException("Variable doesn't exists");

        if(res instanceof Reference) res = this.getRef(str, (Reference) res);
        return res;
    }

    public Object get(String str) {
        Object res = getUnresolvedConst(str);
        if(res instanceof Const) {
            Const const_res = (Const) res;
            return const_res.get();
        }
        return res;
    }


    public void putConst(String str, Object obj) throws IllegalAccessException {
        Object const_obj = new Const(obj);
        put(str, const_obj);
    }

    /*
    Takes variable last context and passes it as reference to current level
     */
    public void putRef(String str) throws IllegalAccessException {
        // if variable to reference is a reference in last context
        int level = size() - 2;
        Object referenced = getContextAt(level).get(str);
        if(referenced == null)  throw new IllegalArgumentException("Referenced variable doesn't exists");

        if(referenced instanceof Reference ){
            put(str, referenced);
        }else {
            put(str, new Reference(level));
        }
    }

    private Object getRef(String str, Reference ref) { return getContextAt(ref.level).get(str); }

    private boolean in(HashMap context, String str) { return context.containsKey(str); }

    public boolean has(String str) {
        return context.containsKey(str) || globalContext.containsKey(str);
    }

    public void pop() {
        if(this.size() == 1) throw new IllegalArgumentException("Can't pop Global context!");
        stack.removeElementAt(stack.size() - 1);
        context = this.stack.lastElement(); // forget context
    }

    public void push() {
        context = new HashMap<>(); //new context
        stack.add(context);
    }

    public int size() { return stack.size(); }
}
