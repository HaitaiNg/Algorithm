#CodeForces
#HQ9+
#Python 3.6.5

import sys
n = input()
condition = True 
for i in n:
    if i == "H" or i == "Q" or i == "9":
        print("YES")
        condition = False 
        break
    else:
        continue

if(condition):
    print("NO") 
