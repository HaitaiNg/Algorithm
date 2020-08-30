# Python 3.6.5 
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mapOfLetters = {}
        mapOfWords = [] 
        for word in strs: 
            sortedLetters = ''.join(sorted(word))
            if(sortedLetters in mapOfLetters.keys()):
                currentList = mapOfLetters.get(sortedLetters)
                currentList.append(word)
                mapOfLetters[sortedLetters] = currentList
            else:
                mapOfLetters[sortedLetters] = [word] 
        for k in mapOfLetters.values():
            mapOfWords.append(k)
        return mapOfWords 
            
        
