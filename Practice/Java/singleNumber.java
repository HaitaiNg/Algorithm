class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int leftPointer = 0;
        int rightPointer = leftPointer + 1;
        int frequency = 0;
        while(rightPointer < nums.length)
        {
            System.out.println(nums[leftPointer]);
            int leftValue = nums[leftPointer];
            int rightValue = nums[rightPointer];
            if(leftValue != rightValue)
            {
                if(leftPointer == 0)
                {
                    return leftValue;
                }
                else
                {
                    if(nums[leftPointer - 1] != leftValue)
                    {
                        return leftValue;
                    }
                    //return rightValue;
                }
            }
            leftPointer++;
            rightPointer++;

        }
        return nums[rightPointer - 1 ];
    }
}
