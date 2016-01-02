package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bruce on 14-11-20.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int last = -1;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                if (i - last > min) {
                    min = i - last;
                }
            } else {
                last = map.get(s.charAt(i)) > last ? map.get(s.charAt(i)) : last;
                map.put(s.charAt(i), i);
                if(i-last>min) {
                    min = i-last;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String a = "msboaguwnnyqxnzlgdgwpbtrwblnsadeuguumoqcdrubetokyxhoachwdvmxxrdryxlmndqtukwagmlejuu";
        LongestSubstringWithoutRepeatingCharacters lo = new LongestSubstringWithoutRepeatingCharacters();
        int result = lo.lengthOfLongestSubstring(a);
        System.out.println(result);
    }

}
