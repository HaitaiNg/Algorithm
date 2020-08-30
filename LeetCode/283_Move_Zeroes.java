// O(1) space || O(n) time 
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++; 
            }
        }
        for(int j = nonZeroIndex; j < nums.length; j++)
        {
            nums[j] = 0; 
        }
    }
}
