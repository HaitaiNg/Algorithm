#include <algorithm>
#include <cmath>
#include <map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> mapObject;
        for(int i = 0; i < nums.size(); i++)
        {
            int complement = target - nums[i];
            if(mapObject.find(complement) != mapObject.end())
            {
                return { mapObject.at(complement), i};
            }
            mapObject[nums[i]] = i;
        }
        return {};
    }
