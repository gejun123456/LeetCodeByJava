package leetcode;

/**
 * Created by bruce on 14-11-22.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int p = S.length();
        int q = T.length();
        if (p == 0 || p < q) {
            return 0;
        }
        int[][] count = new int[p][q];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if(q>p){
                    count[i][j] = 0;
                } else {
                    count[i][j]= -1;
                }

            }
        }
        int result = numCount(S, T, count);
        return result;
    }

    public int numCount(String S, String T, int[][] count) {
        int result = 0;
        int len1 = S.length() - 1;
        int len2 = T.length() - 1;
        if (S.length() < T.length()) {
            return 0;
        }
        if (T.length() == 1) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == T.charAt(0)) {
                    result += 1;
                }
            }
            count[len1][len2] = result;
            return result;
        }
        for (int i = 0; i < S.length() - T.length() + 1; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                int len3 = len1 - i - 1;
                int len4 = len2 - 1;
                if (count[len3][len4] != -1) {
                    result += count[len3][len4];
                } else {
                    result += numCount(S.substring(i + 1, S.length()), T.substring(1, T.length()), count);
                }
            }
        }
        count[len1][len2] = result;
        return result;
    }

    public static void main(String[] args) {
        String a = "rabbbit";
        String b = "rabbit";
        int result = new DistinctSubsequences().numDistinct(a, b);
        System.out.println(result);
    }


}

