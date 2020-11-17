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
public:
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> r; 
        return preorderTraversal(root, r); 
    }
    
    vector<int> preorderTraversal(TreeNode* root, vector<int> r)
    {
        if(root == NULL) return r; 
        r.push_back(root->val); 
        if(root->left != NULL) r = preorderTraversal(root->left, r); 
        if(root->right != NULL) r = preorderTraversal(root->right, r); 
        return r;
    }
};