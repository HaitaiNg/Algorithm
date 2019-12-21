
def findClosestValueInBst(tree, target):
	return findClosestValueInBSTCall(tree, target, float("inf"))


#Average: O(log(n)) time | O(log(N)) space
#Worst: O(n) time | O(n) space 
def findClosestValueInBSTCall(tree, target, closest):
    if tree is None:
        return closest
    if abs(target - closest) > abs(target - tree.value):
        closest = tree.value
    if target < tree.value:
        return findClosestValueInBSTCall(tree.left, target, closest)
    elif target > tree.value:
        return findClosestValueInBSTCall(tree.right, target, closest)
    else:
        return closest

#Average: O(log(n)) time | O(1) space
#Worst: O(n) time | O(1) space
def findClosestValueInBSTCall(tree, target, closest):
	currentNode = tree
	while currentNode is not None:
		if abs(target - closest) > abs(target - currentNode.value):
			closest = currentNode.value
		if(target < currentNode.value):
			currentNode = currentNode.left
		elif(target > currentNode.value):
			currentNode = currentNode.right
		else:
			break
	return closest
