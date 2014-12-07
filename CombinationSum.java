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
        printArr(ca);
        return result;
    }

    private void printArr(Integer[] ca) {
        for (int i = 0; i < ca.length; i++) {
            System.out.printf(ca[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new CombinationSum().combinationSum(input, target);
        for (List<Integer> re : result) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
