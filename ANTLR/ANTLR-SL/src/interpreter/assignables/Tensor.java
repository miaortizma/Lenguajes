package interpreter.assignables;

import interpreter.factories.AbstractFactory;

import java.util.Vector;

public class Tensor implements Assignable<Tensor> {

    private final AbstractFactory factory;
    private int [] dim;
    private int n, openDims;
    private boolean initialized;
    private Vector tensor;


    public Tensor(int [] dim, AbstractFactory factory) {
        n = dim.length;
        if(n == 0)
            throw new RuntimeException();

        int it = 0;
        while(it < n && dim[it] == 0)
            ++it;

        openDims = it;

        while(it < n) {
            if(dim[it] == 0)
                throw new IllegalArgumentException(name() + " with negative dimension");
            if(dim[it] == 1)
                throw new IllegalArgumentException(name() + " with flat dimension");
            ++it;
        }
        initialized = openDims == 0;

        this.dim = dim;
        this.factory = factory;
        if(initialized){
            Assignable assignable = this.factory.build();
            tensor = new Vector(dim[n - 1]);
            for(int i = 0; i < dim[n - 1]; ++i)
                tensor.add(i, assignable);
            for(int i = 1; i < n; ++i)
                tensor = appendDim(dim[i], tensor);
        }
    }

    private Vector appendDim(int dim, Vector vec) {
        Vector ret = new Vector(dim);
        for(int i = 0; i < dim; ++i)
            ret.add(i, vec);
        return ret;
    }

    private String name() {
        return (n == 1)?("Vector"):("Matrix");
    }

    private void validatePos(int [] pos) {
        if(pos.length != n)
            throw new IndexOutOfBoundsException();
        for(int i = 0; i < n; ++i)
            if(0 > pos[i] || pos[i] >= dim[i])
                throw new IndexOutOfBoundsException();
    }

    private Vector getLastVec(int [] pos) {
        Vector vec = tensor;
        for(int i = 0; i < n - 1; ++i)
            vec = (Vector) vec.get(pos[i]);
        return vec;
    }

    public Assignable get(int [] pos) {
        validatePos(pos);
        Vector vec = getLastVec(pos);
        return (Assignable) vec.get(pos[n - 1]);
    }

    public void put(int [] pos, Assignable nextObj) {
        Assignable obj = get(pos);
        obj.AssignIfPossible(nextObj);
    }

    /**
     * Supports
     * tensor = {}
     */
    public void clear() {
        for( int i = 0; i < openDims; ++i )
            dim[i] = 0;

        tensor = null;
    }

    @Override
    public void AssignIfPossible(Tensor obj) {
        if(!initialized)
            for(int i = 0; i < openDims; ++i)
                dim[i] = 0;

        if (factory.equals(obj.factory) && dim == obj.dim)
            tensor = obj.tensor;
    }

}

