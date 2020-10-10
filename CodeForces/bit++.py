#CodeForces 
#Domino Piling
#Python 3.6.5 

import sys 

N = int(input())
x = 0 
while(N > 0):
    instruction = input()
    if "+" in instruction:
        x += 1
    else:
        x -= 1
    N -= 1
print(x) 
