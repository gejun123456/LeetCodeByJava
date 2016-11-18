package leetcode;

/**
 * Created by bruce on 14-11-9.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length()<=1) {
            return s;
        }
        int length = s.length();
        String result = "";
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            int k = 0;
            while(i-k-1>=0&&i+k<length&&s.charAt(i-k-1)==s.charAt(i+k)) {
                k++;

            }
            if(2*k>max) {
                max = 2*k;
                result = s.substring(i-k,i+k);
            }
            k = 0;
            while(i-k>=0&&i+k<length&&s.charAt(i-k)==s.charAt(i+k)) {
                k++;
            }
            if(2*k-1>max) {
                max = 2*k-1;
                result = s.substring(i-k+1,i+k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdesffsedfssfdsf";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome(s));
    }
}
