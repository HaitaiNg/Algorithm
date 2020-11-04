#include <algorithm>
#include <iostream>

using namespace std; 

class Solution {
public:
    int maxPower(string s) {
        int freq = 1, maxFreq = 1; 
        char c = s[0]; 
        for(int i = 0; i < s.length(); i++)
        {
            if(s[i] == s[i+1]) freq++; 
            else freq = 1; 
            
            maxFreq = max(freq, maxFreq); 
        }
        return maxFreq; 
    }
};