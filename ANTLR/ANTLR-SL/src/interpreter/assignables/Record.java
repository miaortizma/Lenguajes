package interpreter.assignables;

import interpreter.factories.AbstractFactory;
import interpreter.factories.DefaultFactory;

import java.util.HashMap;
import java.util.Set;


public class Record implements Assignable {

    private HashMap<String, Assignable> map = new HashMap<>();

    public Record(HashMap<String, AbstractFactory> map) {
        for(String key : map.keySet())
            this.map.put(key, map.get(key).build());
    }

    public static Record FromClassMap(HashMap<String, Class> map) {
        HashMap<String, AbstractFactory> fMap = new HashMap<>();
        for(String key : map.keySet()){
            DefaultFactory factory = new DefaultFactory(map.get(key));
            fMap.put(key, factory);
        }
        return new Record(fMap);
    }

    public Assignable get(String str) {
        return map.get(str);
    }

    public Set<String> keys() { return map.keySet(); }

    public void put(String str, Assignable nextObj) {
        Assignable obj = get(str);
        obj.AssignIfPossible(nextObj);
    }

    @Override
    public boolean IsAssignable(Object obj) {
        if(obj instanceof Record) {
            Record aRecord = (Record) obj;
            Set<String> keySet = map.keySet();
            if(aRecord.map.keySet().equals(keySet)) {
                for(String key : keySet)
                    if(!map.get(key).IsAssignable(map.get(key)))
                        return false;

                return true;
            }
        }
        return false;
    }

    @Override
    public void AssignIfPossible(Object obj) {
        if(!IsAssignable(obj))
            throw new UnsupportedOperationException();
        Record aRecord = (Record) obj;
        for(String key : map.keySet())
            map.get(key).AssignIfPossible(aRecord.get(key));

    }

}
