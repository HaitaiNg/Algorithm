#CodeForces 
#Domino Piling
#Python 3.6.5 

import sys 

lineOne = input()
lineTwo = input()
score = 0

indexOne = 0
for character in lineOne:
    wordTwo = lineTwo[indexOne].lower()
    character = character.lower() 
    if wordTwo > character:
        score = -1
        break
    elif wordTwo < character:
        score = 1
        break 
    else:
        score = 0
    indexOne += 1 
print(score) 
