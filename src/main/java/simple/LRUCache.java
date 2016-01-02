package simple;

/**
 * Created by bruce on 14-11-23.
 */
public class LRUCache {

    private MyLinkedHashMap<Integer,Integer> myLinkedHashMap;

    public LRUCache(int capacity) {
        myLinkedHashMap = new MyLinkedHashMap<Integer,Integer>(capacity);
    }

    public int get(int key) {
        Integer value = myLinkedHashMap.getValue(key);
        if(value==null){
            return -1;
        } else {
            myLinkedHashMap.remove(key);
            myLinkedHashMap.setValue(key,value);
            return value;
        }
    }

    public void set(int key, int value) {
        Integer oldValue = myLinkedHashMap.getValue(key);
        if(oldValue!=null){
            myLinkedHashMap.remove(key);
            myLinkedHashMap.setValue(key,value);
        } else {
            if(myLinkedHashMap.isFull()){
                myLinkedHashMap.removeLast();
                myLinkedHashMap.setValue(key,value);
            } else {
                myLinkedHashMap.setValue(key,value);
            }
        }
    }


    public static class MyLinkedHashMap<K,V>{
        private Node[] table = {};

        private int tableSize;

        private Node first;   //放入的第一个元素

        private Node last;  //放入的最后一个元素

        private int size = 0;

        private int capacity;


        public MyLinkedHashMap(int size){
            //初始化这个hashMap
            this.capacity = size;
            this.tableSize = findBig(size);
            table = new Node[tableSize];
        }

        private int findBig(int size) {
            int k  = 2;
            while(k<size){
                k = k*2;
            }
            return k;
        }

        public V getValue(K key) {
            int cur = hash(key);
            Node<K,V> i = table[cur];
            while(i!=null){
                if(i.key.equals(key)){
                    return i.value;
                }
                i = i.next;
            }
            return null;
        }

        private int hash(K key) {
            return key.hashCode()%tableSize;
        }

        public void setValue(K key, V value) {
            Node<K,V> node = new Node(key,value);
            //先插入到链表中
            int cur = hash(key);
            node.next = table[cur];
            table[cur] = node;
            //如果链表为空  构建这个双链表
            //插入链表的头部
            if(isEmpty()){
                first = node;
                last = node;
            } else {
                node.after = first;
                first.before = node;
                first = node;
            }
            size++;
        }

        //移除一个元素 如果不存在则不管
        public void remove(K key){
            int cur = hash(key);
            Node<K,V> i = table[cur];
            if(i==null){
                return;
            }
            //判断是否是链表头结点
            if(i.key.equals(key)){
                size--;
                removeBalanceLinked(i);
                table[cur] = i.next;
            } else{
                while(i.next!=null){
                    if(i.next.key.equals(key)){
                        size--;
                        removeBalanceLinked(i.next);
                        i.next = i.next.next;
                    }
                }
            }
        }

        //移除最后一个元素
        public void removeLast(){
            Node<K,V> node = last;
            last = last.before;
            int cur = hash(node.key);
            Node<K,V> lastLink = table[cur];
            if(lastLink==node){
                size--;
                table[cur] = node.next;
            } else {
                while(lastLink.next!=null){
                    if(lastLink.next==node){
                        size--;
                        lastLink.next = node.next;
                    }
                }
            }
        }

        //在去除元素时保持链表的平衡
        private void removeBalanceLinked(Node i){
            if(i==first){
                first = i.after;
            } else if(i==last){
                last = i.before;
            } else {
                i.before.after = i.after;
                i.after.before = i.before;
            }
        }

        public static class Node<K,V>{
            K key;
            V value;
            Node next;  //作为数组上的下一个值
            Node after; //后来放入的一个值
            Node before;//前面的一个键 先删后加
            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        //是否放入足够的值
        public boolean isFull(){
            return this.size==capacity;
        }

        public boolean isEmpty(){
            return this.size==0;
        }


    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.set(1,2);
        lruCache.set(2,4);
        System.out.println(lruCache.get(2));
        lruCache.set(5,6);
        lruCache.set(7,8);
        //应该返回-1
        System.out.println(lruCache.get(1));

    }

}
