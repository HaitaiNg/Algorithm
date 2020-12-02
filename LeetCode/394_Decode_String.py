class Solution(object): 
    def decodeString(self, s): 
        stack = []; currentNumber = 0; currentString = '' 
        for c in s: 
            if c == '[': 
                stack.append(currentString) 
                stack.append(currentNumber) 
                currentString = ''
                currentNumber = 0 
            elif c == ']': 
                num = stack.pop() 
                prevString = stack.pop() 
                currentString = prevString + num + currentString
            elif c.isdigit(): 
                currentNumber = currentNumber*10+ int(c) 
            else:
                currentString += c 
        return currentString 