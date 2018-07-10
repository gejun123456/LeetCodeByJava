package leetcode;

import org.junit.Test;

public class MaximumBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==1){
            TreeNode node = new TreeNode(nums[0]);
            return node;
        }
        return findTreeInIndex(nums,0,nums.length-1);
    }

    private TreeNode findTreeInIndex(int[] nums, int start, int end) {
        if(end<start){
            return null;
        }
        if(end==start){
            return new TreeNode(nums[start]);
        }

        int k  = findMaxValueIndexInArray(nums,start,end);

        TreeNode node = new TreeNode(nums[k]);
        TreeNode leftTree = findTreeInIndex(nums,start,k-1);
        TreeNode right = findTreeInIndex(nums,k+1,end);
        node.left=leftTree;
        node.right = right;
        return node;
    }

    private int findMaxValueIndexInArray(int[] nums, int minIndex, int maxIndex) {
        int max = -1;
        int k =-1;
        for (int i = minIndex; i <= maxIndex; i++) {
            if(nums[i]>max){
                max = nums[i];
                k = i;
            }
        }
        return k;
    }


    @Test
    public void testConstructTree(){
        int[] nums = {3,2,1,6,0,5};
        TreeNode node = constructMaximumBinaryTree(nums);
        System.out.println(node);
    }
}
