class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        numMap = {} 
        for i in nums: 
            if i in numMap.keys(): 
                numMap[i]+= 1 
                if(numMap[i] >=3):
                    del numMap[i] 
            else:
                numMap[i] = 1 
        
        for k in numMap.keys():
            return k 
        return -1
        