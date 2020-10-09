#CodeForces 
#String Task  
#Python 3.6.5 

import sys 

vowels = "aeiouyAEIOUY"
user_input = input()
output = ""
for character in user_input:
    if character in vowels:
        pass
    else:
        output += "."
        output += character.lower()
print(output)
