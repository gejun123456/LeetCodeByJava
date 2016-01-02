package tree;

/**
 * Created by bruce on 12/19/2015.
 */
public class TreeNode<T> {
    T x;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode(T x){
        this.x = x;
    }

    public TreeNode(T x,TreeNode<T> left,TreeNode<T> right){
        this.x = x;
        this.left = left;
        this.right = right;
    }
}
