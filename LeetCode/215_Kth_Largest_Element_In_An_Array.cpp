class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        k--;
        std:sort(nums.begin(), nums.end());
        return nums[nums.size() - k - 1];
    }
};