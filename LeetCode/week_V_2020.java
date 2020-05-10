//4.29.30 Binary Tree Maximum Path Sum 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum; 
    public int maxPathSum(TreeNode root) {
        //depth first serach 
        maxSum = Integer.MIN_VALUE; 
        maxGain(root); 
        return maxSum; 
    }
    int maxGain(TreeNode root){
        if(root == null) return 0; 
    
    
    int leftGain = Math.max(maxGain(root.left), 0); 
    int rightGain = Math.max(maxGain(root.right), 0); 
    int sum = root.val + leftGain + rightGain; 
    maxSum = Math.max(maxSum, sum); 
    return root.val + Math.max(leftGain, rightGain); 
    }
}

//4.30.20 Check if a string is valid 
