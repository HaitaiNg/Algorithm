#CodeForces
#Twins
#Python 3.6.5

import sys
import math

num = int(input())
count = 0
while(num):
    if num % 10 == 4 or num % 10 == 7:
        count += 1
    num = num // 10

if count == 4 or count == 7:
    print("YES")
else:
    print("NO")
    
        
    
