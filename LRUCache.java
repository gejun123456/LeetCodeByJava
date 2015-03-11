import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bruce on 14-11-23.
 */
public class LRUCache {
    private LinkedHashMap<Integer,Integer> linkedHashMap;
    private int capacity;
    private int size = 0;
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<Integer, Integer>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if(linkedHashMap.containsKey(key)) {
            int value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
            return value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(linkedHashMap.containsKey(key)){
            linkedHashMap.remove(key);
            linkedHashMap.put(key,value);
        } else {
            linkedHashMap.put(key,value);
        }
    }
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2, 1);
        lruCache.set(2, 2);
        System.out.println(lruCache.get(2));
        lruCache.set(1, 1);
        lruCache.set(4, 1);
        System.out.println(lruCache.get(2));
//        System.out.println(lruCache.get(3));
    }
}
