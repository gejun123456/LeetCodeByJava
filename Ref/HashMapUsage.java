package Ref;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 14-11-3.
 */
public class HashMapUsage {
    public static void main(String[] args) {
        //first cover
        Map map = new HashMap();
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key  = entry.getKey();
            Object val = entry.getValue();
        }

        //second

        Map map1 = new HashMap();
        Iterator iter1 = map1.keySet().iterator();
        while(iter1.hasNext()) {
            Object key = iter1.next();
            Object val = map.get(key);
        }
    }
}
