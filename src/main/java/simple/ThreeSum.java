package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Administrator on 14-10-25.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if(i>0 && num[i]==num[i-1])
                continue;
            if (num[i] > 0)
                break;
            for (int j = i + 1; j < num.length - 1; j++) {
                if(num[j]==num[j-1]&&j!=i+1)
                    continue;
                if (num[i] + num[j] > 0)
                    break;
                for (int z = j + 1; z < num.length; z++) {
                    if(num[z]==num[z-1]&&z!=j+1)
                        continue;
                    if (num[i] + num[j] + num[z] > 0)
                        break;
                    if (num[i] + num[j] + num[z] == 0) {
                        List<Integer> s = new ArrayList<Integer>();
                        s.add(num[i]);
                        s.add(num[j]);
                        s.add(num[z]);
                        result.add(s);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(num);
        for (List<Integer> a : result) {
            for (Integer s : a) {
                System.out.print(s);
            }
            System.out.println("\n");
        }
    }
}
