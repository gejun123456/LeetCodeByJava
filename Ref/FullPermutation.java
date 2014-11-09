package Ref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bruce on 14-11-9.
 */
public class FullPermutation {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int last = -1;
        int current = 0;
        List<Integer> solution = new ArrayList<Integer>();
        generate(result,solution,last,current,num);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> solution, int last, int current, int[] num) {
        if(current>=num.length) {
            List<Integer> newSolution = new ArrayList<Integer>();
            for(Integer i :solution) {
                newSolution.add(i);
            }
            result.add(newSolution);
        }
        else {
            if(last!=-1&&num[current]==num[current-1]&&(current-last)!=1) {
                generate(result, solution, last, current+1, num);
            } else {
                for(int i = 0 ;i<2;i++) {
                    if(i==0) {
                        solution.add(num[current]);
                        generate(result, solution, current, current+1, num);
                        solution.remove(solution.size()-1);
                    }
                    else {
                        generate(result, solution, last, current+1, num);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        FullPermutation su = new FullPermutation();
        List<List<Integer>> result = su.fourSum(num, 0);
        for (List<Integer> so : result) {
            for (Integer i : so) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
