//4.23.20 Bitwise AND of Numbers 
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         while(n>m)
           n = n & n-1;
 return m&n;
    }
}
