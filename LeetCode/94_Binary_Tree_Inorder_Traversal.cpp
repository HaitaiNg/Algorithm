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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> values;
        return inorderTraversal(root, values);
    }
    
    vector<int> inorderTraversal(TreeNode* root, vector<int> values)
    {
        if(root == NULL) return values; 
        if(root->left != NULL) values = inorderTraversal(root->left, values); 
        values.push_back(root->val); 
        if(root->right != NULL) values = inorderTraversal(root->right, values);
        return values; 
    }
};