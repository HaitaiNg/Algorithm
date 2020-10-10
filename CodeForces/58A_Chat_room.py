#CodeForces
#Chat Room
#Python 3.8.5

import sys

DM = input()
characters = ['h','e','l','l','o'] 
for char in DM:
    if len(characters) == 0:
        break
    if characters[0] == char.lower():
        characters.pop(0)
    else:
        pass
    
if len(characters) == 0:
    print("YES")
else:
    print("NO")
