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

// Recurisve breath first search 
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root == NULL) return 0; 
        map<int, vector<int>> levels; 
        levels = breadthFirstSearch(root, levels, 1); 
        return (--levels.end())->first;
    }
    
    map<int, vector<int>> breadthFirstSearch(TreeNode * root, map<int, vector<int>> levels, int level)
    {
        if(root == NULL) return levels; 
        levels[level].push_back(root->val); 
        if(root->left != NULL) levels = breadthFirstSearch(root->left, levels, level + 1);
        if(root->right != NULL) levels = breadthFirstSearch(root->right, levels, level+1); 
        return levels; 
    }
    
};

/*
// Iterative Breath First Search 
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root == NULL) return 0;
        
        queue<TreeNode *> q; 
        q.push(root); 
        int result = 0;
        while(!q.empty())
        {
            ++result;
            for(int i = 0, n = q.size(); i < n;++i)
            {
                TreeNode *c = q.front();
                q.pop(); 
                if(c->left != NULL) q.push(c->left); 
                if(c->right != NULL) q.push(c->right); 
            }
        }
        return result; 
        
    }
};

*/ 