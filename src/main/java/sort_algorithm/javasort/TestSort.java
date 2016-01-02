package sort_algorithm.javasort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bruce on 10/28/2015.
 */
public class TestSort {
    public static class Foo{
        public int key;

        public int value;

        public Foo(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<Foo> lists = new ArrayList<Foo>();
        lists.add(new Foo(1,2));
        lists.add(new Foo(2,2));
        lists.add(new Foo(3,3));
        lists.add(new Foo(1,1));
        lists.add(new Foo(4,3));
        Collections.sort(lists, new Comparator<Foo>() {
            @Override
            public int compare(Foo o1, Foo o2) {
                if(o1.value>o2.value){
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        for(Foo foo : lists){
            System.out.println(foo.key+" " + foo.value);
        }
    }
}
