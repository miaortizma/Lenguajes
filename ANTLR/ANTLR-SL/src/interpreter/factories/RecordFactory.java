package interpreter.factories;

import interpreter.assignables.Assignable;
import interpreter.assignables.Record;

import java.util.HashMap;

public class RecordFactory implements AbstractFactory<Record> {

    HashMap<String, AbstractFactory> attributes = new HashMap<>();

    public RecordFactory(HashMap<String, Object> attributes) {
        for (String key : attributes.keySet()) {
            Object attr = attributes.get(key);
            AbstractFactory factory;
            if(attr instanceof Class){
                Class<Assignable> clss = (Class<Assignable>) attr;
                factory = new DefaultFactory<>(clss);
            }else {
                if (!(attr instanceof AbstractFactory))
                    throw new RuntimeException();
                factory = (AbstractFactory) attr;
            }
            this.attributes.put(key, factory);
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
