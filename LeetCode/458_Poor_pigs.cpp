class Solution {
public:
    int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        long long T = (minutesToTest/ minutesToDie) + 1; 
        long long x = 0; 
        while( pow(T,x) < buckets ){
            x++; 
        }
        return x; 
    }
};