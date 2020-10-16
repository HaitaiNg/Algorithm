#CodeForces 
#Theatre Square     
#Python 3.6.5 

import sys 

userInput = input()
n, m, a = userInput.split()

n = int(n)
m = int(m)
a = int(a) 

x = n // a 
y = m // a 
if n % a != 0: 
    x += 1 
if m % a != 0: 
    y += 1 
print(x*y) 

