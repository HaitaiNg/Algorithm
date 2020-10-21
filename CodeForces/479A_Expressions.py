#CodeForces
#Expresssion
#Python 3.7.2

import sys

a = int(input())
b = int(input())
c = int(input())

print(max([a*b*c, a+(b*c),(a*b)+c, a+b+c, a*(b+c), (a+b)*c]))
