#CodeForces
#Magnets
#Python 3.7.2

import sys
n = int(input())

firstMagnet = input()
magnets = []
magnets.append(firstMagnet)
magnet_chain = firstMagnet

while( n - 1 > 0):
    magnet = input()
    lastMagnet = magnets[-1]
    if(lastMagnet[-1] != magnet[0]):
        magnet_chain += magnet
    else:
        magnet_chain += " " + magnet
    magnets.append(magnet)
    n -=1
    
print(max(len(magnet_chain.split()), 1))
