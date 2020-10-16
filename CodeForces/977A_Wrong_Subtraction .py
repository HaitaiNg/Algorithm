#CodeForces
#Wrong Subtraction
#Python 3.6.5

import sys
tanyas_input = input()
tanyas_input = tanyas_input.split()
target, numberOfOperations = int(tanyas_input[0]), int(tanyas_input[1])

while(numberOfOperations > 0):
    if(target % 10 == 0):
        target /= 10
    else:
        target -= 1 
    numberOfOperations -= 1 
print(int(target))
