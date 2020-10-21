#CodeForces
#Even Odds
#Python 3.6.5

import sys

''' This implementation TLE 
n = input()
n = n.split()
chainOfNumbers = int(n[0])
k = int(n[1])
listOfNumbers = []
i = 1; j = 2

while(i <= chainOfNumbers):
    listOfNumbers.append(i)
    i += 2
    
while(j <= chainOfNumbers):
    listOfNumbers.append(j)
    j += 2
    
print(listOfNumbers[k - 1]) '''

n = input()
n = n.split()
k = int(n[1])
n = int(n[0])

if( k <= (n+1)//2 ):
    print( int(k*2 - 1))
else:
    print( int((k - (n+1)//2)*2))
    
