package interpreter.factories;


import interpreter.assignables.Assignable;
import interpreter.assignables.Record;
import interpreter.assignables.Tensor;

public class TensorFactory<T extends Assignable> implements AbstractFactory<Tensor> {

    private int [] dim;
    private final AbstractFactory<T> factory;
    private final Class<T> clss;

    public TensorFactory(int [] dim, Class<T> clss) {
        if(clss.equals(Tensor.class))
            throw new UnsupportedOperationException("Cannot create a Tensor of tensor");

        factory = new DefaultFactory<>(clss);
        this.clss = clss;
        this.dim = dim;
    }


    // Use for records
    public TensorFactory(int [] dim, AbstractFactory<T> factory, Class<T> clss) {
        if(clss.equals(Tensor.class))
            throw new UnsupportedOperationException("Cannot create a Tensor of tensor");

        this.clss = clss;
        this.factory = factory;
        this.dim = dim;
    }

    public Tensor<T> build() { return new Tensor<>(dim, factory, clss); }

    @Override
    public boolean equals(AbstractFactory<Tensor> factory) {
        if(factory instanceof TensorFactory) {
            TensorFactory tf = (TensorFactory) factory;
            return this.clss.equals(tf.clss) && this.dim.equals(tf.dim);
        }
        return false;
    }

}
