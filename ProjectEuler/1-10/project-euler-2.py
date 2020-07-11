"""
Description: Considering the terms in the Fibonacci Sequence whose 
values do not exceed N, find the sum of even valued terms. 
Completed using Python 3.7.3

"""

#!/bin/python3

import sys

def fibonacciSum(n):
    fibonacciSequence = [1,2] 
    sumOfEvenTerms = 2 
    while(fibonacciSequence[1] < n):
        indexOne = fibonacciSequence[1] 
        fibonacciSequence[1] = fibonacciSequence[0] + fibonacciSequence[1] 
        fibonacciSequence[0] = indexOne 
        if(fibonacciSequence[1] % 2 == 0 and fibonacciSequence[1] < n):
            sumOfEvenTerms += fibonacciSequence[1] 
    print(sumOfEvenTerms)

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    fibonacciSum(n) 