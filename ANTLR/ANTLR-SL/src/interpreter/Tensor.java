package interpreter;

import java.util.Vector;

public class Tensor implements Assignable<Tensor> {

    private final AbstractFactory factory;
    int [] dim;
    int n, openDims;
    boolean initialized;
    Vector tensor;


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
            Object
        }
    }

    private Vector appendDim(int dim, Vector vec) {

    }

    private String name() {
        return (n == 1)?("Vector"):("Matrix");
    }

    public void clear() {
        for( int i = 0; i < openDims; ++i ){
            dim[i] = 0;
        }
        tensor = null;
    }

    @Override
    public void AssignIfPossible(Tensor obj) {
        Tensor nextTensor = (Tensor) obj;
        if(nextTensor.class_ == class_) {
            if(!initialized) return true;
            for(int i = 0; i < )
        }


    }

}

