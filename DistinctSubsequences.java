/**
 * Created by bruce on 14-11-22.
 */
public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        int result = 0;
        if (S.length() < T.length()) {
            return 0;
        }
        if (T.length() == 1) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == T.charAt(0)) {
                    result += 1;
                }
            }
            return result;
        }
        for (int i = 0; i < S.length() - T.length() + 1; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                result += numDistinct(S.substring(i+1, S.length()), T.substring(1, T.length()));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = "rabbbit";
        String b = "rabbit";
        int result = new DistinctSubsequences().numDistinct(a,b);
        System.out.println(result);
    }


}

