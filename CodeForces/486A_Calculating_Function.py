#CodeForces
#Calculating Function
#Python 3.7.2

import sys

n = int(input())
if(n % 2 == 0):
    n = n // 2
    odd = n*n
    even = n*(n+1)
    print( -odd + even) 
else:
    n = (n//2) + 1
    odd = n*n
    even = n*(n+1) - 2*n
    print( -odd + even) 

