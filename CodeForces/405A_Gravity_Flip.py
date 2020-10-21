#CodeForces
#Gravity Flip
#Python 3.7.2

import sys

n_nums = input()
n = input() 
n = n.split()
n = [int(i) for i in n]
n = sorted(n)
n = map(str, n)
print(' '.join(n))
