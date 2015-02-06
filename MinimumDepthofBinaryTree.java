/**
 * Created by bruce on 14-11-10.
 */
public class MinimumDepthofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return min(root, 1);
    }

    private int min(TreeNode root, int i) {
        if (root.left==null&&root.right==null) {
            return i;
        }
        int l = 1000000;
        int r = 1000000;
        if(root.left!=null) {
            l = min(root.left,i+1);
        }
        if(root.right!=null) {
            r = min(root.right,i+1);
        }
        return l<r?l:r;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        a.left = b;
        b.left =c;
        MinimumDepthofBinaryTree mi = new MinimumDepthofBinaryTree();
        int result = mi.minDepth(a);
        System.out.println(result);
    }
}

