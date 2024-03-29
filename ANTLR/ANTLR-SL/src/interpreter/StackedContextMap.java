package interpreter;

import interpreter.assignables.Assignable;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 * read-only
 */
class Const implements Assignable {

    private Object maskedInstance;

    public Const(Object maskedInstance) {
        this.maskedInstance = maskedInstance;
    }

    public Object get() {
        return this.maskedInstance;
    }

    @Override
    public boolean isAssignable(Object obj) {
        return false;
    }

    @Override
    public void assignIfPossible(Object obj) {
        throw new UnsupportedOperationException();
    }
}

/**
 * Function to manage a stacked context which supports:
 * - vertical (push, pop) and horizontal (put, get) context
 * - const elements ( immutable )
 * - referenced elements ( to lower parts of the stack )
 * - no more
 *
 * @author miaortizma
 */
public class StackedContextMap {
    private final int STACK_LIM = 1000;
    private Vector<HashMap<String, Assignable>> stack;
    private HashMap<String, Assignable> globalContext, context;

    public StackedContextMap() {
        this.stack = new Vector<>();
        this.globalContext = new HashMap<>();
        this.context = globalContext;
        stack.add(this.globalContext);
    }

    private HashMap<String, Assignable> getContextAt(int index) {
        if (index < 0 || index > this.size() - 1) throw new IndexOutOfBoundsException();
        return this.stack.elementAt(index);
    }

    private Assignable getUnresolvedConst(String str) {
        Assignable res;
        if (in(context, str))
            res = context.get(str);
        else if (in(globalContext, str))
            res = globalContext.get(str);
        else
            throw new IllegalArgumentException("The variable " + str + " does not exists");

        if (res instanceof Reference)
            res = this.getRef(str, (Reference) res);

        return res;
    }

    public Assignable get(String str) {
        Assignable res = getUnresolvedConst(str);
        if (res instanceof Const) {
            Const cnst = (Const) res;
            if (cnst.get() instanceof Assignable)
                return (Assignable) cnst.get();
        }
        return res;
    }

    /**
     * Places nextObj if possible into current context, which may be global context.
     *
     * @param str
     * @param nextObj
     */
    public void put(String str, Assignable nextObj) {
        //Explore invalid options
        if (in(this.context, str)) {
            Assignable res = getUnresolvedConst(str);
            if (res instanceof Const)
                throw new UnsupportedOperationException("Cannot assign to a const value");
            res.assignIfPossible(nextObj);
        } else {
            context.put(str, nextObj);
        }
    }

    public void putConst(String str, Object obj) {
        Const const_obj = new Const(obj);
        put(str, const_obj);
    }

    /*
    Takes variable last context and passes it as reference to current level
     */
    public void putRef(String str, String toReference) {
        // if variable to reference is a reference in last context
        int level = size() - 2;
        Assignable referenced = getContextAt(level).get(toReference);
        if (referenced == null) throw new IllegalArgumentException("Referenced variable doesn't exists");

        if (referenced instanceof Reference) {
            put(str, referenced);
        } else {
            put(str, new Reference(level));
        }
    }

    private Assignable getRef(String str, Reference ref) {
        return getContextAt(ref.level).get(str);
    }

    private boolean in(HashMap context, String str) {
        return context.containsKey(str);
    }

    public boolean has(String str) {
        return context.containsKey(str) || globalContext.containsKey(str);
    }

    public Set<String> topContextKeys() {
        return context.keySet();
    }

    public void pop() {
        if (this.size() == 1) throw new IllegalArgumentException("Can't pop Global context!");
        stack.removeElementAt(stack.size() - 1);
        context = this.stack.lastElement(); // forget context
    }

    public void push() {
        if (size() == STACK_LIM)
            throw new StackOverflowError();
        context = new HashMap<>(); //new context
        stack.add(context);
    }

    public int size() {
        return stack.size();
    }

    private class Reference implements Assignable {
        int level;

        public Reference(int level) {
            this.level = level;
        }

        @Override
        public boolean isAssignable(Object obj) {
            return false;
        }

        @Override
        public void assignIfPossible(Object obj) {
            throw new UnsupportedOperationException();
        }
    }
}
