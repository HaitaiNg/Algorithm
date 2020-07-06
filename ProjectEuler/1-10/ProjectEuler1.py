#!/bin/python3 

""" 
Description: Find the sum of all multiples 
of 3 or 5 below N. Completed using Python III.  

Naive solution is to use module operator 
This will result in a timeout for test cases 
where N is very large (10^6) 

def multiplesOfThreeAndFive(n):
    i = 0; sum = 0; 
    while(i < n):
        if(i % 3 == 0):
            sum += i 
        elif(i % 5 == 0):
            sum += 1 
        else:
            pass 
        i += 1 
    print(summ) 


Correct solution: Use the arithmetic series & 
Triangle number 
Tn = 1 + 2 + 3 + 4 + 5 .... n 
   = [n(n+1)] / 2 

S3 = sum of all multiples of three 
S3 = 3 + 6 + 9 ... + 3i 
   = 3 ( 1 + 2 + 3 + ....+ i) 
   = [3 (n / 3 )( n / 3 + 1)] / 2 

S5 = sum of all multiples of five 
S5 = 5 + 10 + 15  .... + 5i 
   = 5 ( 1 + 2 + 3 + ..... + i) 
   = [5 * (n / 5)( n / 5 + 1)] / 2 

** You cannot count multiples of 3 & 5 twice.
Subtract common multiples of 3 & 5. To do that 
you subtract the least common multiple of 3 & 5,
which for this example is 15 

S15 = 15 + 30 + 45 ... + 15i 
    = [ 15 * (n / 15)( n /15 + 1)] / 2 

Solution = S3 + S5 - S15 

"""


import sys

def sum(n, k):
    return k * ( (n // k ) * ( (n // k ) + 1)) // 2 

def multiplesOfThreeAndFive(n):
    return sum(n, 3) + sum(n, 5) - sum(n, 15)

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(multiplesOfThreeAndFive(n - 1))