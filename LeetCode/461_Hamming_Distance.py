# Use XOR to solve this problem 
# 1^0 = 1 
# 1^1 = 0 
# 0^0 = 0 

# Different bits will return 1, otherwise 0 

class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        return bin(x^y).count('1')