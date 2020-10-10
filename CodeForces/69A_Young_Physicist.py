#CodeForces
#A Young Physicst
#Python 3.6.5

import sys
n = int(input())
equilibrium = [0,0,0] 
while(n > 0):
    vector = input()
    vector = vector.split()
    pos = 0 
    for coordinate in vector:
        equilibrium[pos] += int(coordinate)
        pos += 1
    n -= 1

isEquilibrium = True
for coordinate in equilibrium:
    if coordinate != 0:
        isEquilibrium = False 
        break

if(isEquilibrium):
    print("YES")
else:
    print("NO")
    
