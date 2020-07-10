"""
Description: Find the absolute difference between the sum of the squares of the
first natural numbers and the square of the sum. I used the 
mathematical sigma notation for sum of squares of n natural numbers:
n(n*1)(2n+1)/6. Completed using Python 3 
"""

#!/bin/python3

import sys

def sumSquareDifference(n):
    squareOfSumOfNaturalNumbers = 0 
    sumOfSquares = ((n) * (n + 1) * (2*n + 1)) / 6 
    for i in range(1, n + 1):
        squareOfSumOfNaturalNumbers += i 
    squareOfSumOfNaturalNumbers = squareOfSumOfNaturalNumbers**2 
    return abs((int) (squareOfSumOfNaturalNumbers - sumOfSquares))

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(sumSquareDifference(n))
