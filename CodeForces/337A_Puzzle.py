#CodeForces
#Puzzles
#Python 3.7.2

import sys

n_and_m = input()
n_and_m.split()
n = int(n_and_m[0]); m = n_and_m[1]

f = input()
f = f.split()
f = [int(i) for i in f]
f.sort()

minimumDifference = float('inf')
count = m
print(f)
for i in range(0, len(f), 1):
    temp = i 
    for j in range(i + 1, len(f), n):
        temp += f[j]
    minimumDifference = min(temp, minimumDifference)
    #print(temp)
    #print(minimumDifference)
    #print("-----")
print(minimumDifference)
        
