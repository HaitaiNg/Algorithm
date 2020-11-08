/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
private:
    int totalTilt = 0; 
public:
    int depthFirstSearch(TreeNode* root)
    {
        if(root == NULL) return 0;
        int left = depthFirstSearch(root->left); 
        int right = depthFirstSearch(root->right); 
        totalTilt += abs(left - right); 
        return root->val + left + right; 
    }
    
    int findTilt(TreeNode* root) {
        int result = depthFirstSearch(root); 
        return abs(totalTilt); 
    }
};