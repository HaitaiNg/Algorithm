#CodeForces
#Translation
#Python 3.6.5

import sys

s = input()
t = input()

left = 0
right = len(t) - 1 
condition = True 
while(left < len(s) and right >= 0):
    if s[left] != t[right]:
        print("NO")
        condition = False
        break 
    else:
        left += 1
        right -= 1

if(condition):
    print("YES") 
        
