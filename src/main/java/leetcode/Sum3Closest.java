package leetcode;

import java.util.Arrays;

/**
 * Created by bruce on 14-11-13.
 */
public class Sum3Closest {
    public int threeSumClosest(int[] num, int target) {
        int result = 0;
        int len = num.length;
        Arrays.sort(num);
        double difference = 1000000;
        for (int i = 0; i < len-2; i++) {
            for (int j=i+1;j < len-1; j++) {
                for (int k=j+1; k < len; k++) {
                        int sum = num[i] + num[j] + num[k];
                        if(Math.abs(sum-target) < difference) {
                            difference = Math.abs(sum - target);
                            result = sum;
                        }
                        if(sum>target) {
                            break;
                        }
                    }
                }
            }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1,2,1,-4};
        Sum3Closest su = new Sum3Closest();
        int result = su.threeSumClosest(num,1);
        System.out.println(result);
    }
}
