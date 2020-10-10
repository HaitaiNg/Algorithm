#CodeForces 
#Helpful Maths 
#Python 3.6.5 

import sys 

xenia_input = input()
xenia_input = xenia_input.split("+")
output = sorted([int(f) for f in xenia_input])
output = [str(f) for f in output]
print('+'.join(output))

