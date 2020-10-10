#CodeForces
#Boy Or Girl 
#Python 3.6.5

import sys
user_input = input()
characterSet = set()
for char in user_input:
    characterSet.add(char)

if(len(characterSet) % 2 == 0):
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!") 
