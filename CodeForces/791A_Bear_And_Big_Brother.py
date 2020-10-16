#CodeForces
#Bear and Big Brother 
#Python 3.8.5 

import sys
weights = input()
weights = weights.split()

limak = int(weights[0])
bob = int(weights[1])

numberOfYears = 0

while(limak <= bob):
    limak *= 3
    bob *= 2
    numberOfYears += 1    
print(numberOfYears)
    
