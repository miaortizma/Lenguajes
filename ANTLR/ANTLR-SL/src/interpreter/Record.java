package interpreter;

import java.util.HashMap;


public class Record implements Assignable<Record> {

    private HashMap<String, Object> map;

    public Record(HashMap<String, AbstractFactory> map) {
        this.map = new HashMap<>();
        for(String key : map.keySet())
            this.map.put(key, map.get(key).build());
    }

    public Object get(String str) {
        return map.get(str);
    }

    public void put(String str, Object obj) {
        map.put(str, obj);
    }

    public void AssignIfPossible(Record obj) {
        if(!map.keySet().equals(obj.map))
            throw new RuntimeException();
        for(String key : map.keySet()) {
            Object obj = map.get(key);
        }
    }

}
