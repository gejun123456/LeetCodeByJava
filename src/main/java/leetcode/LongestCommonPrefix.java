package leetcode;

/**
 * Created by bruce on 14-11-10.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minlen = 100000;
        String min = "";
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            if(len<minlen) {
                minlen = len;
                min = strs[i];
            }
        }
        minlen = 100000;
        String result = "";
        for (int i = 0; i < strs.length; i++) {
            String re = compare(min,strs[i]);
            if(re.length()<minlen) {
                minlen = re.length();
                result = re;
            }
        }
        return result;
    }

    private String compare(String min, String str) {
        int len1 = min.length();
        for (int i = 0; i < len1; i++) {
            if(min.charAt(i)!=str.charAt(i)) {
                return min.substring(0,i);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        String[] strs = {"abcdde", "abcdeed", "abcessw", "abcss", "abc"};
        LongestCommonPrefix lo = new LongestCommonPrefix();
        String result = lo.longestCommonPrefix(strs);
        System.out.printf(result);
    }
}
