import java.util.*;

/**
 * Created by bruce on 14-11-23.
 */
public class LRUCache {

    private MyLinkedHashMap myLinkedHashMap;

    public LRUCache(int capacity) {

    }

    public int get(int key) {

    }

    public void set(int key, int value) {

    }


    public static class MyLinkedHashMap<K,V>{
        private Node[] table = {};

        private Node first;   //放入的第一个元素

        private Node last;  //放入的最后一个元素

        private int size = 0;

        private int capacity;


        public MyLinkedHashMap(int size){
            //初始化这个hashMap
            this.capacity = size;
            int tableSize = findBig(size);
            table = new Node[tableSize];
        }

        private int findBig(int size) {
            int k  = 2;
            while(k<size){
                k = k*2;
            }
            return k;
        }

        public V get(K key) {

        }

        public void set(K key, V value) {

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

        public void put(K key,V value){

            //如果map为空
            if(isEmpty()){
            }
        }

        public int get(K key){

        }

        //是否放入足够的值
        public boolean isFull(){
            return this.size==capacity;
        }

        public boolean isEmpty(){
            return this.size==0;
        }


    }

}
