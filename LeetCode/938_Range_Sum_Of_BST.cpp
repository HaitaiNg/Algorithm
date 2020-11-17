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
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(root == NULL) return -1; 
        int result = 0; 
        queue<TreeNode*> q; 
        q.push(root); 

        while(!q.empty())
        {
            TreeNode * c = q.front(); 
            int qSize = q.size(); 
            q.pop(); 
            if(c->left != NULL) q.push(c->left);
            if(c->right != NULL) q.push(c->right);
            if(c->val >= low && c->val <= high)
            {
            result += c->val; 
            }
        }
        return result; 
    }
};