"""
Description: Summation of primes.
Find the sum of all the primes not greater than a
given N. Completed using Python 3.6.5

Inspired by a solution that was previously submitted by
https://www.hackerrank.com/prateekmishra95. This problem
requires a very time efficient solution which is why
it is recommended to solve for all primes then just search
the corresponding value in a list of all summation of primes. 
""" 
#!/bin/python3

import sys

def sieveOfEratosthenes(n=1000000):
    isPrime = [True] * (n) 
    listOfValues = [0] * (n) 
    isPrime[0] = False 
    isPrime[1] = False 
    p = 1
    while(p < n):
        if(isPrime[p]):
            listOfValues[p] = listOfValues[p - 1] + p
            for i in range( p*p, n, p):
                isPrime[i] = False 
        else:
            listOfValues[p] = listOfValues[p-1]
        p += 1 
    return listOfValues

listOfValues = sieveOfEratosthenes()
t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(listOfValues[n])

