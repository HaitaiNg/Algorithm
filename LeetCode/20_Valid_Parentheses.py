class Solution(object):
    def isValid(self, s):
        paren_map = {')':'(', '}':'{', ']':'['}
        stack = [] 
        for i in s: 
            if i in "({[":
                stack.append(i) 
            if i in paren_map.keys():
                if len(stack) <= 0:
                    return False 
                lri = stack.pop()
                if paren_map[i] != lri:
                    return False 
        return len(stack) == 0 
    