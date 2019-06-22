package interpreter.assignables;

import interpreter.factories.AbstractFactory;

import java.util.HashMap;


public class Record implements Assignable<Record> {

    private HashMap<String, Assignable> map;

    public Record(HashMap<String, AbstractFactory> map) {
        this.map = new HashMap<>();
        for(String key : map.keySet())
            this.map.put(key, map.get(key).build());
    }

    public Assignable get(String str) {
        return map.get(str);
    }

    public void put(String str, Assignable nextObj) {
        Assignable obj = get(str);
        obj.AssignIfPossible(nextObj);
    }

    public void AssignIfPossible(Record obj) {
        if(!map.keySet().equals(obj.map))
            throw new RuntimeException();
        for(String key : map.keySet()) {
            map.get(key).AssignIfPossible(obj.get(key));
        }
    }

}
