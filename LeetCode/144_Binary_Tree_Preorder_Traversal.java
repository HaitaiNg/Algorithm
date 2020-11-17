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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> r = new ArrayList<Integer>(); 
        return preOrderTraversal(root, r); 
    }
    
    public List<Integer> preOrderTraversal(TreeNode root, List<Integer> r)
    {
        if(root == null) return r; 
        r.add(root.val); 
        if(root.left != null) r = preOrderTraversal(root.left, r); 
        if(root.right != null) r = preOrderTraversal(root.right, r); 
        return r; 
    }
}