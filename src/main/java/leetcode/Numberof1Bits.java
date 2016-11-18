package leetcode;

/**
 * Created by bruce on 6/6/2015.
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        long b = n&0xffffffffl;
        int res = 0;
        while (b > 0) {
            if (b % 2 == 1) {
                res++;
            }
            b = b / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Numberof1Bits().hammingWeight(11));

    }
}
