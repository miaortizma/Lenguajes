package interpreter.factories;

import interpreter.assignables.Assignable;
import interpreter.assignables.Record;

import java.util.HashMap;
import java.util.Vector;

public class RecordFactory implements AbstractFactory<Record> {

    private HashMap<String, AbstractFactory> attributes;
    private Vector<String> order;

    public RecordFactory(HashMap<String, Object> attributes, Vector<String> order) {
        if (order.size() != attributes.size())
            throw new RuntimeException("Order and attributes have different size");
        this.attributes = new HashMap<>();
        for (String key : order) {
            Object attr = attributes.get(key);
            AbstractFactory factory;
            if(attr instanceof Class){
                Class<Assignable> clss = (Class) attr;
                factory = new DefaultFactory<>(clss);
            } else {
                if (!(attr instanceof AbstractFactory))
                    throw new RuntimeException();
                factory = (AbstractFactory) attr;
            }
            this.attributes.put(key, factory);
        }
        this.order = new Vector<>();
        this.order.addAll(order);
    }

    public Record build() {
        return new Record(attributes, order);
    }

    public Vector<String> getOrder() { return order; }

    public HashMap<String, AbstractFactory> getAttributes() { return attributes; }

    @Override
    public boolean equals(AbstractFactory<Record> factory) {
        return false;
    }
}
