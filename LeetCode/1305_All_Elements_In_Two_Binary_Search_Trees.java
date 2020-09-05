/*
Runtime: 16 ms, faster than 67.63% of Java online submissions for All Elements in Two Binary Search Trees.
Memory Usage: 42.3 MB, less than 83.75% of Java online submissions for All Elements in Two Binary Search Trees.
*/ 

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
import java.util.*; 

class Solution {
    
    public static void traverseTree(TreeNode root, List<Integer> listOfNodes)
    {
        if(root == null) return;  
        listOfNodes.add(root.val); 
        traverseTree(root.left, listOfNodes); 
        traverseTree(root.right, listOfNodes); 
        return; 
    }
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> listOfNodes = new ArrayList<Integer>(); 
        traverseTree(root1, listOfNodes);
        traverseTree(root2, listOfNodes); 
        Collections.sort(listOfNodes);
        return listOfNodes;  
    }
}
