package leetcode;

/**
 * Created by Administrator on 14-11-3.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] mid = new int[100000];
        int length = digits.length;
        int k = 1;
        int f = 0;
        for (int i = length - 1; i >= 0; i--, f++) {
            if (k == 1) {
                mid[f] = digits[i] + 1;
                if (mid[f] == 10) {
                    mid[f] = 0;
                    k = 1;
                } else {
                    k = 0;
                }
            } else {
                mid[f] = digits[i];
            }
        }
        if (k == 1) {
            mid[f] = 1;
            f++;
        }
        int[] result = new int[f];
        for (int i = 0; i < f; i++) {
            result[i] = mid[f - 1 - i];
        }
        return result;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] source = {10000000};
        int[] result = plusOne.plusOne(source);
        for(int i = 0;i<result.length;i++ ) {
            System.out.println(result[i]);
        }
    }
}
