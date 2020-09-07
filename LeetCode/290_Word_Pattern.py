class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        mapIndex = {} 
        words = str.split() 
        if(len(pattern) != len(words)):
            return False 
        for i in range(len(words)):
            c = pattern[i] 
            w = words[i] 
            
            char_key = 'char_{}'.format(c) 
            char_word = 'word_{}'.format(w) 
            if char_key not in mapIndex: 
                mapIndex[char_key] = i 
            if char_word not in mapIndex: 
                mapIndex[char_word] = i 
            if mapIndex[char_key] != mapIndex[char_word]:
                return False 
        return True 
        