#CodeForces
#Twins
#Python 3.6.5

import sys

n = int(input())
coins = input().split()
coins = [int(i) for i in coins]
coins.sort()
totalSum = sum(coins)
totalSum /= 2
mySum = 0; count = 0 

j = len(coins) - 1
while(j >= 0):
    mySum += coins[j]
    count += 1
    if(mySum > totalSum):
        break
    j -=1
    
print(count) 
