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
    public int answer = 1; 
    
    public int diameterHelper(TreeNode root){
        if(root == null) return 0; 
        int left = diameterHelper(root.left);
        int right = diameterHelper(root.right); 
        answer = Math.max(answer, left + right + 1); 
        return Math.max(left, right)+1; 
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root); 
        return answer - 1; 
        
    }
}