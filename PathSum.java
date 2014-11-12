public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) {
            return false;
        }
        if(root!=null&&root.left==null&&root.right==null&&root.val==sum) {
            return true;
        }
        boolean l = false;
        boolean r = false;
        if(root.left!=null) {
            l = hasPathSum(root.left,sum-root.val);
            if(l == true) {
                return true;
            }
        }
        if(root.right!=null) {
            r = hasPathSum(root.right,sum-root.val);
            if(r == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(13);
        TreeNode h = new TreeNode(4);
        TreeNode i = new TreeNode(7);
        TreeNode j = new TreeNode(2);
        TreeNode k = new TreeNode(1);
        a.left = b;
        a.right =c;
        b.left = d;
        d.left = i;
        d.right = j;
        c.left = e;
        c.right = h;
        h.right = k;
        PathSum pa = new PathSum();
        boolean result = pa.hasPathSum(a,22);
        System.out.println(result);
    }
}
