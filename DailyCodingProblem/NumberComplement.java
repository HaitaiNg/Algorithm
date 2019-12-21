class Solution {
    public int findComplement(int num) {
        int numberOfBits = (int) (Math.floor(Math.log(num) / Math.log(2))) + 1;
        return ((1 << numberOfBits) - 1) ^ num;
    }
}

/* Given a positive integer, output its complement number.
The complement strategy is to flip the bits of its binary representation

An efficient approach is
  Find the number of bits in the given integer
  XOR the given integer with 2^(numberOfBits) - 1 
*/
