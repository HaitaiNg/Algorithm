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
    vector<int> inorderTraversal(TreeNode* root, vector<int> queue)
    {
        if(root == NULL) return queue; 
        if(root->left != NULL) queue = inorderTraversal(root->left, queue);
        queue.push_back(root->val); 
        if(root->right != NULL) queue = inorderTraversal(root->right, queue); 
        return queue; 
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> queue;
        return inorderTraversal(root, queue);
    }
};