def balancedBrackets(string):
	# O(n) time | O(n) space
	# n is the space of the string
	# All operations are constant
	# Using a stack.
	openingBrackets = "{[("
    closingBrackets = "}])"
	matchingBrackets = { ")" : "(", "]":"[", "}": "{"}
	stack = []
	for char in string:
		if char in openingBrackets:
			stack.append(char)
		elif char in closingBrackets:
			#if the length of the stack is 0
			if(len(stack) == 0):
				return False
			if(matchingBrackets[char] == stack[-1]):
					stack.pop()
			else:
				return False

	return len(stack) == 0
			
