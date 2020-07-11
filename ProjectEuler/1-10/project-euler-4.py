"""
Description: Largest palindrome product. Find 
the largest palindrome made from the product 
of two 3-digit numbers which is less than N.
Completed using Java 8. 
"""

#!/bin/python3
import sys
def isPalindrome(x):
    if(x < 0 or (x != 0 and x % 10 == 0)): 
        return False 
    remain = 0
    while(x > remain):
        temp = x % 10 
        remain = remain * 10 + temp 
        x /= 10 
    return x == remain or x == remain / 10 
    
def largestPalindromeProduct(n):
    palindromicValue = -1 
    for i in range(100, 1000):
        for j in range(100, 1000):
            product = i * j 
            if(isPalindrome(product)):
                if(product > palindromicValue and product < n ):
                    palindromicValue = product 
    print(palindromicValue)
    return palindromicValue 
    
t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(largestPalindromeProduct(n))