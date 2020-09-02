'''
Runtime: 36 ms, faster than 46.88% of Python3 online submissions for Backspace String Compare.
Memory Usage: 13.8 MB, less than 74.66% of Python3 online submissions for Backspace 

Time: O(M+N) where M, N are the lengths of S and T 
Space: O(M + N)
'''
class Solution:
    def createStack(self, S): 
        stack = [] 
        for i in S:
            if i == "#" and len(stack) > 0:
                stack.pop()
            elif i != "#":
                stack.append(i) 
            else:
                pass 
        return stack 
    
    def backspaceCompare(self, S: str, T: str) -> bool:
        return self.createStack(S) == self.createStack(T)
        