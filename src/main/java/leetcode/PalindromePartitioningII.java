package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bruce on 14-12-8.
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        int n = s.length();
        int[] res = new int[n];
        res[0] = 0;
        Map<Integer, List<Integer>> count = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            int h = 1;
            while ((k - h) >= 0 && (k + h) < n && s.charAt(k - h) == s.charAt(k + h)) {
                if (!count.containsKey(k + h)) {
                    List<Integer> co = new ArrayList<Integer>();
                    co.add(k - h);
                    count.put(k + h, co);
                } else {
                    count.get(k + h).add(k - h);
                }
                h++;
            }
            h = 0;
            while((k-h)>=0&&(k+h+1)<n&&s.charAt(k-h)==s.charAt(k+h+1)) {
                if(!count.containsKey(k+h+1)) {
                    List<Integer> co = new ArrayList<Integer>();
                    co.add(k-h);
                    count.put(k+h+1,co);
                } else {
                    count.get(k+h+1).add(k-h);
                }
                h++;
            }
        }
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1]+1;
            if(count.containsKey(i)) {
                List<Integer> co = count.get(i);
                for (int j = 0; j < co.size(); j++) {
                    int m = co.get(j);
                    if(m==0){
                        res[i] =0;
                        break;
                    } else {
                        if(res[m-1]+1<res[i]) {
                            res[i] =res[m-1]+1;
                        }
                    }
                }
            }
        }
        return res[n-1];
    }

    public static void main(String[] args) {
        String s = "abacabaddab";
        int result = new PalindromePartitioningII().minCut(s);
        System.out.println(result);
    }
}
