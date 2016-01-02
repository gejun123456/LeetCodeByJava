package simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 14-10-23.
 */
public class BinaryTreeLevelOrderTraversalI {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            List<Integer> point = new ArrayList<Integer>();
            point.add(root.val);
            result.add(point);
            List<TreeNode> listNode;
            listNode = addRootToList(root);
            while (listNode.size() != 0) {
                List<Integer> nextPoint = convertToList(listNode);
                result.add(nextPoint);
                listNode = createNewListNode(listNode);
            }
            result = convertToBottom(result);
        }
        return result;
    }

    private List<List<Integer>> convertToBottom(List<List<Integer>> result) {
        List<List<Integer>> convertResult = new ArrayList<List<Integer>>();
        for (int i = result.size() - 1; i >= 0; i--) {
            convertResult.add(result.get(i));
        }
        return convertResult;
    }

    private List<TreeNode> createNewListNode(List<TreeNode> listNode) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        for (TreeNode node : listNode) {
            List<TreeNode> nodeList = addRootToList(node);
            for (TreeNode nextNode : nodeList) {
                result.add(nextNode);
            }
        }
        return result;
    }

    private List<Integer> convertToList(List<TreeNode> listNode) {
        List<Integer> point = new ArrayList<Integer>();
        for (TreeNode node : listNode) {
            point.add(node.val);
        }
        return point;
    }

    private List<TreeNode> addRootToList(TreeNode root) {
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        if (root.left != null) {
            listNode.add(root.left);
        }
        if (root.right != null) {
            listNode.add(root.right);
        }
        return listNode;
    }
}
