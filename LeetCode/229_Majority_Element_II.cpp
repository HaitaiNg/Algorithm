class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int frequency = (int) std::floor(nums.size() / 3);
        map<int, int> k;
        vector<int> r; 
        for(int& c : nums){
            if(k.find(c) != k.end()){
                k[c]++;  
            }else{
                k[c] = 1; 
            }
        }
        
        for(auto const&[key, val]: k)
        {
            if(val > frequency) r.push_back(key); 
        }
        return r; 
    }
};