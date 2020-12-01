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
#include <algorithm>
#include <iostream>


class Solution {
public:
    int answer = 1; 
    int diameterHelper(TreeNode* root){
        if(root == NULL) return 0; 
        int left = diameterHelper(root->left);
        int right = diameterHelper(root->right); 
        answer = std::max(answer, left + right + 1); 
        return std::max(left, right) + 1; 
    }
    
    int diameterOfBinaryTree(TreeNode* root) {
        diameterHelper(root); 
        return answer - 1; 
    }
};