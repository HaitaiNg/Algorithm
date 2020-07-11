""" 
Description: Find the greatest K 
consecutive digits in the N digit number.
Completed using python 3.6.5 
""" 
#!/bin/python3
import sys
import functools
from functools import reduce 

def largest_product(num, n, k):
    max = 0 
    for i in range(n - k):
        p = reduce(lambda x, y: x*y, map(int, num[i:i+k])) 
        max = p if p > max else max 
    print(max)
    return max 

t = int(input().strip())
for a0 in range(t):
    n,k = input().strip().split(' ')
    n,k = [int(n),int(k)]
    num = input().strip()
    largest_product(str(num), n, k)
