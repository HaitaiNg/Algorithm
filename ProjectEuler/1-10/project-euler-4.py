"""
Description: Largest palindrome product. Find 
the largest palindrome made from the product 
of two 3-digit numbers which is less than N.
Completed using Python 3.6.5 

Solution is based off of user: bacdoxuan's solution
in the discussion 
"""

#!/bin/python3
import sys    

palindromeList = [] 
for i in range(100, 1000):
    for j in range(100, 1000):
        product = i * j
        if(str(product) == str(product)[::-1] and product not in palindromeList):
            palindromeList.append(product)
palindromeList.sort()
length = len(palindromeList) 

if __name__ == '__main__':
    n = int(input())
    for _ in range(n):
        a = int(input())
        for i in range(length - 1, -1, -1):
            if palindromeList[i] < a:
                print(palindromeList[i])
                break 