class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int count = 0;
        int left = 0, right = nums.size() - 1; 
        while(left <= right)
        {
            string x = to_string(nums[left]); 
            string y = to_string(nums[right]); 
            if(x.size() % 2 == 0) count++; 
            if(y.size() % 2 == 0 && left != right) count++; 
            left++;
            right--;
        }
        return count;    
    }
};