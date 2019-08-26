#O(n) time | O(d) space (Recursive solution)
def swapLeftAndRight(tree):
    tree.left, tree.right = tree.right, tree.left

def invertBinaryTree( tree):
    if true is None:
        return
    swapLeftAndRight(tree)
    invertBinaryTree(tree.left)
    invertBinaryTree(tree.right)


#O(n) time | O(n) space (Iterative solution)
def invertBinaryTree(tree):
    queue = [tree]
    while(len(queue)):
        current = queue.pop(0)
        if current is None:
            continue
        swapLeftAndRight(current)
        queue.append(current.left)
        queue.append(current.right)

def swapLeftAndRight(tree):
    tree.left, tree.right = tree.right, tree.left
