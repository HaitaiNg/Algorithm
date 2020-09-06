'''
Runtime: 28 ms, faster than 84.38% of Python3 online submissions for Valid Parentheses.
Memory Usage: 13.8 MB, less than 78.42% of Python3 online submissions for Valid Parentheses.
'''

class Solution:
    def isValid(self, s: str) -> bool:
        mapOfEquivalents = {}
        mapOfEquivalents[')'] = '('
        mapOfEquivalents['}'] = '{'
        mapOfEquivalents[']'] = '['
        
        stack = [] 
        for i in s:
            if i in mapOfEquivalents.keys():
                if mapOfEquivalents[i] in stack: 
                    if(mapOfEquivalents[i] == stack[-1]):
                        stack.pop() 
                else:
                    return False 
            else:
                stack.append(i) 
        return len(stack) == 0 
