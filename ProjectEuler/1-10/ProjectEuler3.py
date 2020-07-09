"""
Description: The prime factors of 13195 are 5,7,13
and 29. What is the largest prime factor of 
a given number N? Completed using Python 3.7.5 

This solution is based off of : Oussama Zaki. I liked 
how he used a refined version of Eratosthenes sieve 
"""

#!/bin/python3
import sys
import math 

def largestPrimeFactorsOfANumber(n):
    maxPrime = -1 
    # Divide by 2 to eliminate all even composite factors 
    while n % 2 == 0:
        maxPrime = 2 
        n //= 2 
    #Loop over potential odd factors 
    #Update maxPrime to the largest factor 
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0: 
            maxPrime = i 
            n //= i 
    return n if n > 2 else maxPrime 

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(largestPrimeFactorsOfANumber(n)) 