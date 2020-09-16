class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if len(s) <= 0:
            return 0 
        s = s.rstrip() 
        count = 0 
        rightPointer = len(s) - 1 
        while(rightPointer >= 0):
            if s[rightPointer] == ' ': 
                return count 
            rightPointer -= 1 
            count += 1 
        return count 