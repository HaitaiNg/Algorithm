# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def isSymmetric(self, root):
        if root == None:
            return True 
        return self.isSymmetricHelper(root, root) 
    
    def isSymmetricHelper(self, left, right): 
        if left == None and right == None:
            return True 
        if left == None or right == None:
            return False 
        return (left.val == right.val) and self.isSymmetricHelper(left.left, right.right) and self.isSymmetricHelper(left.right, right.left)
        