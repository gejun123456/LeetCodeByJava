package code_2016.leetcode_44;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce.ge on 2016/10/26.
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> stringlist = new ArrayList<String>();
        String a = "hello";
        stringlist.add(a);
        a="nimei";
        System.out.println(a);
        for (int i = 0; i < stringlist.size(); i++) {
            System.out.println(stringlist.get(i));
        }
    }
}
