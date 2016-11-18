package leetcode;

/**
 * Created by bruce on 4/19/2015.
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int g = k % len;
        if (g == 0) {
            return;
        }
        int minCon = countMin(g, len);
        if (minCon == 1) {
            rotateh(nums, k, len, len, 0);
        } else {
            for (int i = 0; i < minCon; i++) {
                int h = len / minCon;
                int start = i;
                rotateh(nums, k, len, h, start);
            }
        }
    }

    private void rotateh(int[] nums, int k, int len, int h, int start) {
        int i = 0;
        int q = nums[start];
        int j = start;
        while (i < h) {
            i++;
            int m = nums[(j + k) % len];
            nums[(j + k) % len] = q;
            q = m;
            j = (j + k) % len;
        }
    }

    private int countMin(int g, int len) {
        if (g == 1) {
            return 1;
        } else {
            if (len % g == 0) {
                return g;
            } else {
                return countMin(len % g, g);
            }
        }
    }

    private void toright(int[] nums) {
        int first = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = first;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6,7,8};
        new RotateArray().rotate(nums, 2);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
