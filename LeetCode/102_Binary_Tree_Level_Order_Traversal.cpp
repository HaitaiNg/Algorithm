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
#include <utility> 
#include <iostream>
#include <map> 

using namespace std; 

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        map<int, vector<int>> values ; 
        values = levelOrder(root, values, 0); 
        vector<vector<int>> result;
        for(auto const& [key, val] : values)
        {
            result.push_back(val); 
        }

        return result;
    }
    
    map<int, vector<int>> levelOrder(TreeNode* root, map<int, vector<int>> values, int level)
    {
        if(root == NULL) return values; 
        values[level].push_back(root->val); 
        if(root->left != NULL) values = levelOrder(root->left, values, level + 1); 
        if(root->right != NULL) values = levelOrder(root->right, values, level + 1); 
        return values; 
    }
};