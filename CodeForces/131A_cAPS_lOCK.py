#CodeForces
#cAPSLOCK
#Python 3.7.2

import sys
word = input()

if word == word.upper():
    print(word.lower())
elif word[0] == word[0].lower() and word[1:] == word[1:].upper():
    print(word[0].upper() + word[1:].lower())
else:
    print(word)
    
