import java.util.*;

/**
 * Created by bruce on 14-11-23.
 */
public class LRUCache {
    private int capacity;
    private int size = 0;
    private Node start;
    private Node end;
    private Set<Integer> set = new HashSet<Integer>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return 1;
    }

    public void set(int key, int value) {
        if (size == 0) {
            start = new Node(key, value);
            end = start;
            set.add(key);
            size++;
            return;
        }
        if (!set.contains(key)) {
            if (size == capacity) {
                Node q = end;
                set.remove(q.key);
                end = end.before;
                q = null;
                size--;
            }
            Node m = start;
            Node u = new Node(key, value);
            u.next = m;
            start = u;
            size++;
            set.add(key);
        } else {
            Node r = start;
            while (r != null) {
                if (r.key == key) {
                    Node a = r.before;
                    Node b = r.next;
                    a.next = b;
                    b.before = a;
                    r.next =start;
                    start = r;
                    break;
                }
                r = r.next;
            }
        }
    }


    static class Node {
        int key;
        int value;
        Node next;
        Node before;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
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
