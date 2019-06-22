package interpreter;


public class TensorFactory implements AbstractFactory<Tensor> {

    private int [] dim;
    private final AbstractFactory factory;

    public TensorFactory(int [] dim, RecordFactory factory) {
        this.factory = factory;
        this.dim = dim;
    }

    public Tensor build() {
        return new Tensor(dim, factory);
    }

    @Override
    public boolean equals(AbstractFactory<Tensor> factory) {
        return false;
    }

}
