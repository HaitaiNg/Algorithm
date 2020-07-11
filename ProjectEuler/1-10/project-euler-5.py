"""
Description: What is the smallest number that can be divided by 
each of the numbers from  to without any remainder. 
What is the smallest positive number that 
is evenly divisible(divisible with no remainder) 
by all of the numbers from  to? Completed using Python 3 
"""

#!/bin/python3

import sys

def smallestMultiple(n):
    multiple = n
    numberOfDivisions = 0  
    while(True):
        for i in range(1, n + 1):
            if(multiple % i  == 0):
                numberOfDivisions += 1
            else:
                numberOfDivisions = 0 
                break 
        if(numberOfDivisions == n):
            return multiple
        multiple += 1 

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(smallestMultiple(n)) 