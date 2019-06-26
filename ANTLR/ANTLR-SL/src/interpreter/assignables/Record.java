package interpreter.assignables;

import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;

import java.util.HashMap;
import java.util.Set;
import java.util.Vector;


public class Record extends Assignable {
    private HashMap<String, Assignable> map;
    private Vector<String> order;

    public Record(HashMap<String, AbstractFactory> map, Vector<String> order) {
        this.map = new HashMap<>();
        for (String key : order)
            this.map.put(key, map.get(key).build());
        this.order = order;
    }

    public static Record FromClasses(HashMap<String, Class> map, Vector<String> vec) {
        HashMap<String, AbstractFactory> fMap = new HashMap<>();
        if (vec.size() != map.size())
            throw new RuntimeException("Vec and map sizes are wrong");
        for (String key : vec) {
            DefaultFactory factory = new DefaultFactory(map.get(key));
            fMap.put(key, factory);
        }
        return new Record(fMap, vec);
    }

    public Assignable get(String str) {
        return map.get(str);
    }

    public Set<String> keys() {
        return map.keySet();
    }

    public void put(String str, Assignable nextObj) {
        Assignable obj = get(str);
        obj.assignIfPossible(nextObj);
    }

    @Override
    public boolean isAssignable(Object obj) {
        if (obj instanceof Record) {
            Record aRecord = (Record) obj;
            Set<String> keySet = map.keySet();
            if (aRecord.map.keySet().equals(keySet)) {
                for (String key : keySet)
                    if (!map.get(key).isAssignable(map.get(key)))
                        return false;
                return true;
            }
        }
        return false;
    }

    @Override
    public void assignIfPossible(Object obj) {
        if (!isAssignable(obj))
            throw new UnsupportedOperationException();
        Record aRecord = (Record) obj;
        for (String key : map.keySet())
            map.get(key).assignIfPossible(aRecord.get(key));
    }
}
