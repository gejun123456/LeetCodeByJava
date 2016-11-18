package leetcode;

/**
 * Created by bruce on 14-11-30.
 */

import java.util.*;

/**
 * Created by bruce on 14-11-18.
 */
public class MinimumWindowSubstring_v2 {
    public static int INT_MAX = 0x7fffffff;

    public String minWindow(String S, String T) {
        Map<Character, Integer> source = new HashMap<Character, Integer>();
        if (T.length() == 0 || T.length() > S.length()) {
            return "";
        }
        for (int i = 0; i < T.length(); i++) {
            Character cur = T.charAt(i);
            if (!source.containsKey(cur)) {
                source.put(cur, 1);
            } else {
                source.put(cur, source.get(cur) + 1);
            }
        }
        HashMap<Character, Integer> last = new HashMap<Character, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int len = INT_MAX;
        int front = 0;
        int end = 0;
        int min = 0;
        int flag = 0;
        int ff = 0 ;
        for (int i = 0; i < S.length(); i++) {
            Character cur = S.charAt(i);
            if (!source.containsKey(cur)) {
                continue;
            } else {
                if (!last.containsKey(cur)) {
                    last.put(cur, 1);
                    result.add(i);
                } else {
                    last.put(cur, last.get(cur) + 1);
                    result.add(i);
                    if (result.size() > min && cur == S.charAt(result.get(min))) {
                        while (last.get(S.charAt(result.get(min))) > source.get(S.charAt(result.get(min)))) {
                            last.put(S.charAt(result.get(min)), last.get(S.charAt(result.get(min))) - 1);
                            min++;
                        }
                    }
                }
                if (flag == 0&&result.size()-min>= T.length()) {
                    for (Iterator it = source.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry entry = (Map.Entry) it.next();
                        Character c = (Character)entry.getKey();
                        if (!last.containsKey(c)||last.get(c)<source.get(c)) {
                            ff =1;
                            break;
                        } else {
                            ff = 0;
                        }
                    }
                    if(ff==0) {
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    if (i - result.get(min) < len) {
                        end = i;
                        front = result.get(min);
                        len = end - front;
                    }
                }
            }
        }
        if (len != INT_MAX) {
            return S.substring(front, end + 1);
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        String s = "acbbaca";
        String t = "aba";
        MinimumWindowSubstring_v2 mi = new MinimumWindowSubstring_v2();
        String result = mi.minWindow(s, t);
        System.out.println(result);
    }
}

