#CodeForces
#Word
#Python 3.8.5

import sys

user_input = input()
lowercaseCount = 0 
uppercaseCount = 0
uppercase = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}
for i in user_input:
    if i in uppercase:
        uppercaseCount += 1
    else:
        lowercaseCount += 1

if(uppercaseCount > lowercaseCount):
    print(user_input.upper())
else:
    print(user_input.lower())
