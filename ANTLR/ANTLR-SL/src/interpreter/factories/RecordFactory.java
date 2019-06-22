package interpreter.factories;

import interpreter.assignables.Record;

import java.util.HashMap;

public class RecordFactory implements AbstractFactory<Record> {

    HashMap<String, AbstractFactory> attributes;

    public RecordFactory(HashMap<String, Object> attributes) {
        for (String key : attributes.keySet()) {
            Object attr = attributes.get(key);
            if (!(attr instanceof AbstractFactory))
                throw new RuntimeException();
            AbstractFactory factory = (AbstractFactory) attr;
            attributes.put(key, factory);
        }
    }


    public Record build() {
        return new Record(attributes);
    }


    @Override
    public boolean equals(AbstractFactory<Record> factory) {

        return false;
    }

}
