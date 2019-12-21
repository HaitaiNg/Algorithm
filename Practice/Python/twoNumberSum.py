# O(nlog(n)) | O(1) space
def twoNumberSum(array, targetSum):
	array.sort()
	left = 0
	right = len(array) - 1
	while(left < right):
		summ = array[left] + array[right]
		if(summ == targetSum):
			return [array[left], array[right]]
		elif( summ > targetSum):
			right -= 1
		elif( summ < targetSum):
			left += 1
	return []
