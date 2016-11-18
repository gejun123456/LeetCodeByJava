package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bruce on 14-11-10.
 */
public class WordBreak {
    private int k = 0;
    public boolean wordBreak(String s, Set<String> dict) {
        if (dict.contains(s)) {
            return true;
        }
        if (k == 0) {
            for (int i = 0; i < s.length(); i++) {
                String last = s.substring(i, s.length());
                if (dict.contains(last)) {
                    k = 1;
                    break;
                }
            }
            if (k == 0) {
                return false;
            }
        }
        k=1;
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (dict.contains(sub)) {

                boolean current = wordBreak(s.substring(i, s.length()), dict);
                if (current == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");
        String s = "leetcode";
        WordBreak wo = new WordBreak();
        boolean result = wo.wordBreak(s, dict);
        System.out.println(result);
    }
}
