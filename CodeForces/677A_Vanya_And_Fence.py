#CodeForces
#Vanya and Fence
#Python 3.6.5

import sys

n_height = input().split()
n = int(n_height[0])
h = int(n_height[1])

friends = input().split()
friends = [int(f) for f in friends]

width = 0
for i in friends:
    if(i > h):
        width += 2
    else:
        width += 1
print(width)
