class Solution{
    public:
        // O(v+e) time | O(e) space (iterative approach) 
        vector<vector<int>> levelOrder(TreeNode* root){
            if(!root){return {}; }; 
            vector<vector<int>> levels; 
            queue<TreeNode *> q;
            q.push(root); 
            while(!q.empty()){
                levels.push_back({}); 
                for(int i = 0, n = q.size(); i < n; i++){
                    TreeNode* node = q.front();
                    q.pop(); 
                    levels.back().push_back(node->val); 
                    if(node->left) q.push(node->left);
                    if(node->right) q.push(node->right); 
                }
            }
            return levels; 
        }
};