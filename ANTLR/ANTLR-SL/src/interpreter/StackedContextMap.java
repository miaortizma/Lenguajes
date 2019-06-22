package interpreter;

import interpreter.assignables.Assignable;

import java.util.HashMap;
import java.util.Vector;

/**
 * Function to manage a stacked context which supports:
 * - vertical (push, pop) and horizontal (put, get) context
 * - const elements ( immutable )
 * - referenced elements ( to lower parts of the stack )
 * - no more
 * @author miaortizma
 */
public class StackedContextMap {


    /**
     * read-only
     */
    private class Const implements Assignable {

        private Assignable maskedInstance;

        public Const(Assignable maskedInstance) {
            this.maskedInstance = maskedInstance;
        }

        public Assignable get() { return this.maskedInstance; }

        @Override
        public void AssignIfPossible(Object obj) { }
    }

    private class Reference implements Assignable {

        int level;

        public Reference(int level) { this.level = level; }

        @Override
        public void AssignIfPossible(Object obj) { }
    }


    private Vector<HashMap<String, Assignable>> stack;
    private HashMap<String, Assignable> globalContext, context;


    public StackedContextMap() {
        this.stack = new Vector<>();
        this.globalContext = new HashMap<>();
        this.context = globalContext;
        stack.add(this.globalContext);
    }

    private HashMap<String, Assignable> getContextAt(int index) {
        if(index < 0 || index > this.size() - 1) throw new IndexOutOfBoundsException();
        return this.stack.elementAt(index);
    }

    /**
     * Places nextObj if possible into current context, which may be global context.
     * @param str
     * @param nextObj
     */
    public void put(String str, Assignable nextObj) {
        //Explore invalid options
        if(in(this.context, str)) {
            Assignable res = get(str);
            res.AssignIfPossible(nextObj);
        }
        this.context.put(str, nextObj);
    }


    public Assignable get(String str) {
        Assignable res;

        if(in(context, str))
            res = context.get(str);
        else if(in(globalContext, str))
            res = globalContext.get(str);
        else
            throw new IllegalArgumentException("Variable doesn't exists");

        if(res instanceof Reference)
            res = this.getRef(str, (Reference) res);

        if(res instanceof Const) {
            Const const_res = (Const) res;
            return const_res.get();
        }
        return res;
    }


    public void putConst(String str, Assignable obj) {
        Const const_obj = new Const(obj);
        put(str, const_obj);
    }

    /*
    Takes variable last context and passes it as reference to current level
     */
    public void putRef(String str) throws IllegalAccessException {
        // if variable to reference is a reference in last context
        int level = size() - 2;
        Assignable referenced = getContextAt(level).get(str);
        if(referenced == null)  throw new IllegalArgumentException("Referenced variable doesn't exists");

        if(referenced instanceof Reference ){
            put(str, referenced);
        }else {
            put(str, new Reference(level));
        }
    }

    private Assignable getRef(String str, Reference ref) { return getContextAt(ref.level).get(str); }

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
