""" 
Description: Calculate the Nth prime number. Completed using 
Python 3.6.5. 

This problem is very tricky since the solution
has to be optimized and efficient. I faced a lot of run time 
errors / time limit exceeded. I created a modified version of 
sieve of eratosthenes however this would result in a time limit
exceeded. This is a problem I will have to re-attempt again """ 

#!/bin/python3
import math

def prime(n,listOfPrimeNumbers):
    x=listOfPrimeNumbers[-1]
    while len(listOfPrimeNumbers) < n:
        x+=2
        y=math.floor(x**0.5)
        for i in listOfPrimeNumbers:
            if i>y:
                listOfPrimeNumbers.append(x)
                break
            if x%i==0:
                break
    return listOfPrimeNumbers


t=int(input())
listOfPrimeNumbers =[2,3]
for i in range(t):
    n=int(input())
    if len(listOfPrimeNumbers)<n:
        listOfPrimeNumbers =prime(n,listOfPrimeNumbers)
    print(listOfPrimeNumbers[n-1])