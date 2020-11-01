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
    vector<int> postOrderTraversal(TreeNode* root, vector<int> queue)
    {
        if(root == NULL) return queue; 
        if(root->left != NULL) queue = postOrderTraversal(root->left, queue); 
        if(root->right != NULL) queue = postOrderTraversal(root->right, queue); 
        queue.push_back(root->val); 
        return queue; 
    }
    
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> queue; 
        return postOrderTraversal(root, queue); 
    }
};