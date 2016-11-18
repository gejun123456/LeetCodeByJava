package leetcode;

/**
 * Created by bruce on 14-11-9.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        int len = A.length;
        if (len == 0 || len == 1) {
            return 0;
        }
        int result = 0;
        int[] maxr = new int[len];
        int[] maxl = new int[len];
        maxr[len - 1] = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > maxr[i + 1]) {
                maxr[i] = A[i];
            } else {
                maxr[i] = maxr[i + 1];
            }
        }
        maxl[0] = A[0];
        for (int i = 1; i < len - 1; i++) {
            if (A[i] > maxl[i - 1]) {
                maxl[i] = A[i];
            } else {
                maxl[i] = maxl[i - 1];
            }
            int min = maxl[i] > maxr[i] ? maxr[i] : maxl[i];
            int add = min > A[i] ? min - A[i] : 0;
            result += add;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater tr = new TrappingRainWater();
        int result = tr.trap(A);
        System.out.println(result);
    }
}
