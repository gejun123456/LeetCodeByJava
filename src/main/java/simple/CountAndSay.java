package simple;

import java.util.HashMap;

/**
 * Created by Administrator on 14-10-23.
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        HashMap<Integer, String> maps = new HashMap<Integer, String>();
        maps.put(1, "1");
        maps.put(2, "11");
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                String result = new String();
                String before = maps.get(i - 1);
                if (before.length() == 1) {
                    result = "1" + before;
                    maps.put(i, result);
                } else {
                    int j = 0;
                    int count;
                    while (j < before.length()) {
                        count = 1;
                        while (j< before.length()-1 && (before.charAt(j) == before.charAt(j+1))) {
                            count++;
                            j++;
                        }
                        if (count > 1) {
                            result += String.valueOf(count) + before.charAt(j);
                        }
                        else{
                            result += "1" + before.charAt(j);
                        }
                        j++;
                    }
                    maps.put(i,result);
                }
            }
        }
        return maps.get(n);
    }

    public static void main(String args[]) {
        System.out.println(countAndSay(4));
    }
}
