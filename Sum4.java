import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bruce on 14-11-9.
 */
public class Sum4 {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        int last = -1;
        int current = 0;
        List<Integer> solution = new ArrayList<Integer>();
        generate(result, solution, last, current, num, target);
        return result;
    }

    private void generate(List<List<Integer>> result, List<Integer> solution, int last, int current, int[] num, int target) {
        if (solution.size() > 4) {
            return;
        }
        if(current==num.length&&solution.size()<4) {
            return;
        }
        if (solution.size() == 4 ) {
            List<Integer> newSolution = new ArrayList<Integer>();
            int sum = 0;
            for (Integer i : solution) {
                sum += i;
                newSolution.add(i);
            }
            if (sum == target) {
                result.add(newSolution);
            }
        } else {
            if (last != -1 && num[current] == num[current - 1] && (current - last) != 1) {
                generate(result, solution, last, current + 1, num,target);
            } else {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        solution.add(num[current]);
                        generate(result, solution, current, current + 1, num,target);
                        solution.remove(solution.size() - 1);
                    } else {
                        generate(result, solution, last, current + 1, num,target);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        Sum4 su = new Sum4();
        List<List<Integer>> result = su.fourSum(num, 0);
        for (List<Integer> so : result) {
            for (Integer i : so) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
