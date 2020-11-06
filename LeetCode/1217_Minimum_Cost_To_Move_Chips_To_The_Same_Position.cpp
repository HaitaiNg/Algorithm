#include <cmath>

class Solution {
public:
    int minCostToMoveChips(vector<int>& position) {
        int ones = 0, zero = 0; 
        for(int& i : position)
        {
            if(i % 2 != 0)
            {
                ones++; 
            }
            else
            {
                zero++; 
            }
        }
        
        if(zero > ones) return ones;
        return zero; 
    }
};