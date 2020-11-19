// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        return firstBadVersion(0, n); 
    }
    
    int firstBadVersion(long long left, long long right)
    {
        long long  mid = (left+right)/2; 
        bool bv = isBadVersion(mid); 
        if(isBadVersion(mid-1) == false && bv) return mid; 
        if(bv) 
        {
            return firstBadVersion(left, mid); 
        }
        else{
            return firstBadVersion(mid+1, right); 
        }
    }
};