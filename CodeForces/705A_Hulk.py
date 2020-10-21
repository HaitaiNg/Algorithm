#CodeForces
#HULK
#Python 3.6.5

import sys

n = int(input())
hate = True 
hulkSays = ["I"]
flag = True 
while(n > 0):
    if(flag):
        hulkSays.append("hate")
        flag = False 
    else:
        hulkSays.append("love")
        flag = True
    hulkSays.append("that") 
    n -= 1

    if(n > 0):
        hulkSays.append("I")

hulkSays = hulkSays[:-1]
hulkSays.append("it")
print(' '.join(hulkSays))
