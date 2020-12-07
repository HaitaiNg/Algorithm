# O(log(n)) time | O(log(n)) space 
def binarySearchCall(array, target, left, right):
	if(left > right):
		return -1
	midpoint = int((left + right ) / 2 )
	match = array[midpoint]
	if(target == match):
		return midpoint
	elif (match > target):
		return binarySearchCall(array, target, left, midpoint - 1)
	else:
		return binarySearchCall(array, target, midpoint + 1, right)

def binarySearch(array, target):
	return binarySearchCall(array, target, 0, len(array) - 1)