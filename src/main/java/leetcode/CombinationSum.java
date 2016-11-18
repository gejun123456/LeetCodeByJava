package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bruce on 14-12-7.
 */
public class CombinationSum {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    int[] solution = new int[1005];

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Integer[] ca = new Integer[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            ca[i] = candidates[i];
        }
        Arrays.sort(ca, Collections.reverseOrder());
//        printArr(ca);
        if(ca.length==0 ) {
          return result;
        }
        addArr(0,0,ca,target);
        return result;
    }

    private void addArr(int i, int pos, Integer[] ca, int target) {
        int len = ca.length;
        int p = pos;
        int g = target / ca[i];
        if(i == ca.length-1) {
            if(target%ca[i]==0) {
                addDataToresult(i, ca, p, g);
            } else {
                return;
            }
        }else{
            for (int j = 0; j <=g; j++) {
                int res = target-ca[i]*j;
                if(res==0) {
                    p = pos;
                    addDataToresult(i,ca,p,j);
                } else {
                    p = pos;
                    for (int k = 0; k < j; k++) {
                        solution[p++]=ca[i];
                    }
                    addArr(i + 1, p, ca, res);
                }
            }
        }
    }

    private void addDataToresult(int i, Integer[] ca, int p, int g) {
        for (int j = 0; j < g; j++) {
            solution[p++] = ca[i];
        }
        List<Integer> so = new ArrayList<Integer>();
        for(int j = p-1 ;j>=0;j--) {
            so.add(solution[j]);
        }
        result.add(so);
    }

    private void printArr(Integer[] ca) {
        for (int i = 0; i < ca.length; i++) {
            System.out.printf(ca[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 5};
        int target = 8;
        List<List<Integer>> result = new CombinationSum().combinationSum(input, target);
        for (List<Integer> re : result) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
