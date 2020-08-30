
// Kadane's Algorithm 
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE; 
        int currentWindowSum = nums[0], largestSum = nums[0]; 
        for(int i = 1; i < nums.length; i++)
        {
            currentWindowSum = Math.max(currentWindowSum + nums[i], nums[i]); 
            largestSum = Math.max(largestSum, currentWindowSum);
        }
        return largestSum;  
    }
}
