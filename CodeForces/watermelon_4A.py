#CodeForces
# A.Watermelon 
# Python 3.6.5 

import sys 
watermelonSize = input() 

#BitWise Operators 
result = int(watermelonSize) & 1 
result = bin(result)[1:] 
if "0" in result and int(watermelonSize) > 2:
    print("Yes")
else:
    print("No")
