package interpreter.assignables;

import interpreter.factories.AbstractFactory;

import java.util.Vector;

public class Tensor<T extends Assignable> implements Assignable {
    private final AbstractFactory<T> factory;
    private final Class<T> clss;
    private final int[] dim;
    private int n, openDims;
    private boolean initialized;
    private Vector tensor;

    public Tensor(int[] dim, AbstractFactory<T> factory, Class<T> clss) {
        n = dim.length;
        if (n == 0)
            throw new RuntimeException();

        int it = 0;
        while (it < n && dim[it] == 0)
            ++it;

        openDims = it;

        while (it < n) {
            if (dim[it] == 0)
                throw new IllegalArgumentException(name() + " with negative dimension");
            if (dim[it] == 1)
                throw new IllegalArgumentException(name() + " with flat dimension");
            ++it;
        }

        initialized = openDims == 0;
        this.dim = dim;
        this.factory = factory;
        this.clss = clss;

        if (initialized) {
            Assignable assignable = this.factory.build();
            tensor = new Vector(dim[n - 1]);
            for (int i = 0; i < dim[n - 1]; ++i)
                tensor.add(i, assignable);
            for (int i = 1; i < n; ++i)
                tensor = appendDim(dim[i], tensor);
        }
    }

    private Vector appendDim(int dim, Vector vec) {
        Vector ret = new Vector(dim);
        for (int i = 0; i < dim; ++i)
            ret.add(i, vec);
        return ret;
    }

    private String name() {
        return (n == 1) ? ("Vector") : ("Matrix");
    }

    private void validatePos(int[] pos) {
        if (pos.length != n)
            throw new IndexOutOfBoundsException();
        for (int i = 0; i < n; ++i)
            if (!(1 <= pos[i] && pos[i] <= dim[i]))
                throw new IndexOutOfBoundsException();
    }

    private void validateInitialized() {
        if (!initialized)
            throw new UnsupportedOperationException();
    }

    private Vector getLastVec(int[] pos) {
        Vector vec = tensor;
        for (int i = 0; i < n - 1; ++i)
            vec = (Vector) vec.get(pos[i] - 1);
        return vec;
    }

    public T get(int[] pos) {
        validateInitialized();
        validatePos(pos);
        Vector vec = getLastVec(pos);
        return (T) vec.get(pos[n - 1] - 1);
    }

    public void put(int[] pos, Object nextObj) {
        validateInitialized();
        validatePos(pos);
        T obj = get(pos);
        obj.assignIfPossible(nextObj);
    }

    /**
     * Supports
     * tensor = {}
     */
    public void clear() {
        if (openDims == 0)
            throw new UnsupportedOperationException();
        for (int i = 0; i < openDims; ++i)
            dim[i] = 0;
        initialized = false;
        tensor = null;
    }

    public int[] getDim() {
        return dim;
    }

    @Override
    public boolean isAssignable(Object obj) {
        if (obj instanceof Tensor) {
            Tensor aTensor = (Tensor) obj;
            if (aTensor.initialized) {
                boolean sameDims = true;

                if (!initialized)
                    for (int i = openDims; i < n; ++i)
                        sameDims &= dim[i] == aTensor.dim[i];

                return (factory.equals(aTensor.factory) && sameDims);
            }
        }
        return false;
    }

    @Override
    public void assignIfPossible(Object obj) {
        if (!isAssignable(obj))
            throw new UnsupportedOperationException("Can't assign " + obj.getClass() + " to " + name() + " of " + this.clss);

        Tensor aTensor = (Tensor) obj;
        if (!initialized)
            for (int i = 0; i < openDims; ++i)
                dim[i] = aTensor.dim[i];

        initialized = true;
        tensor = aTensor.tensor;
    }
}

