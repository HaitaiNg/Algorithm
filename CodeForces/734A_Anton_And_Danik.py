#CodeForces
#Anton And Denik
#Python 3.7.2

import sys

n = int(input())
order = input()

Anton = 0
Danik = 0
for i in order:
    if i == "A":
        Anton += 1
    elif i == "D":
        Danik += 1
    else:
        continue

if(Anton > Danik):
    print("Anton")
elif(Anton < Danik):
    print("Danik")
else:
    print("Friendship") 
