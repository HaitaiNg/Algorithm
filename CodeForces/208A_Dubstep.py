#CodeForces
#Python 3.6.5
#DubStep

import sys

dubstep = input()
dubstep = dubstep.split("WUB")
output = ""
for i in dubstep:
    if(len(i) >= 1):
        output += i
        output += " "
print(output)
