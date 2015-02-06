import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 14-11-19.
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        List<Integer> solution = new ArrayList<Integer>();
        findPath(result, solution, root, sum);
        return result;
    }

    private void findPath(List<List<Integer>> result, List<Integer> solution, TreeNode root, int sum) {
        if (root.val == sum&&root.right==null&&root.left==null) {
            solution.add(root.val);
            List<Integer> so = new ArrayList<Integer>();
            for (Integer s : solution) {
                so.add(s);
            }
            result.add(so);
            solution.remove(solution.size()-1);
        } else {
            if (root.left != null) {
                solution.add(root.val);
                findPath(result, solution, root.left, sum - root.val);
                solution.remove(solution.size()-1);
            }
            if (root.right != null) {
                solution.add(root.val);
                findPath(result, solution, root.right, sum - root.val);
                solution.remove(solution.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("not this time");
    }
}
