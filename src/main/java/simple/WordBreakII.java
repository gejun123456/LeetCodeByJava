package simple;

import java.util.*;

/**
 * Created by Administrator on 14-10-26.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        String res = "";
        int k = 1;
        for (Iterator it = dict.iterator(); it.hasNext(); ) {
            String prefix = it.next().toString();
            if (s.endsWith(prefix)) {
                k = 2;
                break;
            }
        }
        if (k == 2)
            judge(result, s, dict, res);

        return result;
    }

    private void judge(List<String> result, String s, Set<String> dict, String res) {
        for (Iterator it = dict.iterator(); it.hasNext(); ) {
            String prefix = it.next().toString();
            if (s.equals(prefix)) {
                result.add(res + prefix);
            } else if (s.startsWith(prefix)) {
                judge(result, s.substring(prefix.length(), s.length()), dict, res + prefix + " ");
            }
        }
    }

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("a");
        set.add("aa");
        set.add("aaaa");
//        set.add("sand");
//        set.add("dog");
        String s = "aaaaaaa";
        List<String> result = new ArrayList<String>();
        WordBreakII wordBreak = new WordBreakII();
        result = wordBreak.wordBreak(s, set);
        for (String hehe : result) {
            System.out.println(hehe);
        }
    }
}
