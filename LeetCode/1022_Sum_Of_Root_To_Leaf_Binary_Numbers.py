# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    answer = 0 
    def sumRootToLeaf(self, root: TreeNode) -> int:
        self.depthFirstSearch(root, 0) 
        return self.answer 
    
    def depthFirstSearch(self, root, val): 
        if(root == None):
            return 
        val = val << 1 | root.val 
        if root.left == None and root.right == None:
            self.answer += val 
        self.depthFirstSearch(root.left, val)
        self.depthFirstSearch(root.right, val) 
        