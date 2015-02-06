import java.util.*;

/**
 * Created by bruce on 14-11-18.
 */
public class MinimumWindowSubstring {
    public static int INT_MAX = 0x7fffffff;
    public String minWindow(String S, String T) {
        Map<Character, Integer> source = new HashMap<Character, Integer>();
        if(T.length()==0||T.length()>S.length()) {
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
        HashMap<Character, List<Integer>> last = new HashMap<Character, List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();
        int len = INT_MAX;
        int front = 0;
        int end = 0;
        int size = 0;
        for (int i = 0; i < S.length(); i++) {
            Character cur = S.charAt(i);
            if (!source.containsKey(cur)) {
                continue;
            } else {
                if (!last.containsKey(cur)) {
                    List<Integer> la = new ArrayList<Integer>();
                    la.add(i);
                    last.put(cur, la);
                    result.add(i);
                    size++;
                } else {
                    List l = last.get(cur);
                    if (l.size() < source.get(cur)) {
                        l.add(i);
                        result.add(i);
                        size++;
                    } else {
                        result.remove(l.get(0));
                        l.remove(0);
                        l.add(i);
                        result.add(i);
                    }
                }
                if (size == T.length()) {
                    if (i - result.get(0) < len) {
                        end = i;
                        front = result.get(0);
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
        String s = "fdslsfdsdssfdss";
        String t = "dss";
        MinimumWindowSubstring mi = new MinimumWindowSubstring();
        String result = mi.minWindow(s, t);
        System.out.println(result);
    }
}
