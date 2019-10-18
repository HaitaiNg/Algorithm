class Solution(object):
    def searchInsert(self, nums, target):
        if(target in nums):
            return nums.index(target)
        else:
            rightMostPointer = len(nums) - 1
            currentPointer = len(nums) - 2

            #base case
            if(nums[rightMostPointer] < target):
                return len(nums)
            if(nums[0] > target):
                return 0


            while(currentPointer >= 0):
                #print(str(nums[rightMostPointer]) + " " + str(nums[currentPointer]))
                if(nums[rightMostPointer] > target) and (nums[currentPointer] < target):
                    return currentPointer + 1
                else:
                    rightMostPointer -= 1
                    currentPointer -= 1
            return -100

                    
