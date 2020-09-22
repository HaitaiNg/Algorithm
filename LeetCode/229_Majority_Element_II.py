class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        targetCount = len(nums) // 3 
        mapCount = {} 
        returnList = [] 
        for num in nums:
            if num in mapCount.keys():
                mapCount[num] += 1 
            else:
                mapCount[num] = 1 
            if num not in returnList: 
                if mapCount[num] > targetCount:
                    returnList.append(num)
        return returnList 