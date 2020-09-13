def isPalindrome(string):
    leftPointer = 0
	rightPointer = len(string) - 1
	while(leftPointer <= rightPointer):
		if(string[leftPointer] != string[rightPointer]):
			return False
		else:
			leftPointer += 1
			rightPointer -= 1
	return True 
