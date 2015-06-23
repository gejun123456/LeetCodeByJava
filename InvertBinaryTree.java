/**
 * Created by bruce on 6/23/2015.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode p = root.left;
        TreeNode q = root.right;
        root.left = q;
        root.right = p;
        invertTree(p);
        invertTree(q);
        return root;
    }
}
