class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        if len(s) == 0:
            return t 
        s = sorted(s) 
        t = sorted(t) 
        sIndex = 0 
        for i in t: 
            sCharacter = s[sIndex] 
            if sCharacter != i : 
                return i 
            
            if sIndex != len(s) - 1: 
                sIndex += 1
            else:
                pass 
        return t[-1] 
        