class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(mapp.containsKey( target - nums[i]))
            {
                return new int[] { mapp.get( target - nums[i]), i };
            }
            else
            {
                mapp.put( nums[i], i);
            }
        }
        return null;
    }
}
