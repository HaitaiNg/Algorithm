'''
Runtime: 344 ms, faster than 92.99% of Python3 online submissions for All Elements in Two Binary Search Trees.
Memory Usage: 20.2 MB, less than 67.99% of Python3 online submissions for All Elements in Two Binary Search Trees.
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def traverseTree(self, root, listOfNodes):
        if(root == None):
            return listOfNodes 
        listOfNodes.append(root.val)
        if (root.left != None):
            self.traverseTree(root.left, listOfNodes)
        if (root.right != None):
            self.traverseTree(root.right, listOfNodes)
        return listOfNodes 
        
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        rootOne = self.traverseTree(root1, [])
        rootTwo = self.traverseTree(root2, []) 
        rootOne.extend(rootTwo)
        return sorted(rootOne)
        
