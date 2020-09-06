//Solution inspired by Errchito (Prefix sums and suffix sums)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] pref_product = new int[n + 1];
        pref_product[0] = 1; 
        int lastElement = 0; 
        int index = 1; 
        for(int x: nums)
        {
            pref_product[index] = pref_product[lastElement] * x;
            index++; lastElement++; 
            
        }
        int[] suf_product = new int[ n + 1]; 
        suf_product[n] = 1; 
        for(int i = n - 1; i >= 0; --i)
        {
            suf_product[i] = suf_product[i + 1] * nums[i]; 
        }
        int[] returnArray = new int[n];
        for(int i = 0; i < n; i++)
        {
            returnArray[i] = pref_product[i] * suf_product[i + 1];
        }
        return returnArray; 
    }
}
