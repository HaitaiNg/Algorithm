#Three number sum (ideal algorithm)
# Sort the array
# Use two loops and iterate through the array
# Use Left pointer and Right pointer
# member variable (int currentSum = currentNumber + left + right)
#    check is ( currentSum = targetSum) ?
#      if(currentSum > targetSum) : move left pointer
#      else if (currentSum < targetSum) : move right pointer

#once you have an occurrence where currentSum == targetSum
#you have to move both pointers (left++, right--) to check if there are
#any values in between that equal to the targetSum

#O(n^2) time | O(n) space
def threeNumberSum(array, targetSum):
    array.sort()
    triplets = []
    for i in range(len(array) - 2):
        left = i + 1
        right = len(array) - 1
        while left < right:
            currentSum = array[i] + array[left] + array[right]
            if currentSum == targetSum:
                triplets.append( [ array[i], array[left], array[right]])
                left += 1
                right -= 1
            elif currentSum > targetSum:
                right -= 1
            elif currentSum < targetSum:
                left += 1
    return triplets
