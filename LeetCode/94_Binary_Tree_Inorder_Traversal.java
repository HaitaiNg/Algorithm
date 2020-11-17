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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>(); 
        return inorderTraversal(root, r); 
    }
    
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> r)
    {
        if(root == null) return r; 
        if(root.left != null) r = inorderTraversal(root.left, r); 
        r.add(root.val); 
        if(root.right != null) r = inorderTraversal(root.right, r); 
        return r; 
    }
}