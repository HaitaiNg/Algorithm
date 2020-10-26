#CodeFroces
#Puzzles
#Python 3.6.5

import sys
n_and_m = input().split()
n = int(n_and_m[0])
m = int(n_and_m[1])
puzzles = input().split()
puzzles = [int(i) for i in puzzles]
puzzles.sort()

currentDifference = float('inf') 
for i in range(0, m):
    if i + n - 1 < m:
        currentDifference = min(currentDifference, puzzles[i + n - 1] - puzzles[i])
    else:
        break 
print(currentDifference) 
        
