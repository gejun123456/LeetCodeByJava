package simple;

import java.util.HashSet;

/**
 * Created by bruce on 14-11-17.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> res = new HashSet<Integer>();
        if (num.length == 0) {
            return 0;
        }
        int min = num[0];
        int max = num[0];
        for (int i = 0; i < num.length; i++) {
            res.add(num[i]);
        }
        int s = 1;
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            if (res.contains(num[i] - 1)) {
                continue;
            } else {
                int cur = num[i];
                while (res.contains(++cur)) {
                    s++;
                }
                if (s > result) {
                    result = s;
                }
                s = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {0, -1};
        LongestConsecutiveSequence lo = new LongestConsecutiveSequence();
        int result = lo.longestConsecutive(num);
        System.out.println(result);
    }
}
