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
    int result = 0; 
public:
    int maxAncestorDiff(TreeNode* root) {
        if(root == NULL) return 0; 
        
        helper(root, root->val, root->val); 
        return result; 
    }
    
    void helper(TreeNode* node, int max, int min)
    {
        if(node == NULL) return; 
        
        int test = std::max( abs(max - node->val), abs(min - node->val)); 
        result = std::max(result, test); 
        max = std::max(max, node->val); 
        min = std::min(min, node->val); 
        helper(node->left, max, min); 
        helper(node->right, max, min); 
        return; 
    }
};