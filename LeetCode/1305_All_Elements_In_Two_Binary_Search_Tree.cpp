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
    vector<int> result; 
    
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        inorder(root1);
        inorder(root2); 
        sort(result.begin(), result.end()); 
        return result; 
    }
    
    void inorder(TreeNode * root)
    {
        if(root != NULL){
            inorder(root->left);
            result.push_back(root->val); 
            inorder(root->right); 
        }
    }
};