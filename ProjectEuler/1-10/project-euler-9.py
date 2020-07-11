""" 
Description: Pythagorean triple is a set of
three natural numbers a < b < c for which
a^2 + b^2 = c^2. Given N check if there 
exists any pythagorean triplet for which a+b+c = N 
If no pythagorean triplet exists, return -1
Completed using Python 3.6.5 
""" 


#!/bin/python3
import sys
def pythagoreanTriple(n):
    product = -1 
    for a in range(3, (n//3) + 1):
        b = (n**2 - 2*a*n) // (2*n - 2*a) 
        c = n - b - a
        if a*a + b*b == c*c:
            if a*b*c > product: 
                product = a*b*c 
    return product 

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(pythagoreanTriple(n))
