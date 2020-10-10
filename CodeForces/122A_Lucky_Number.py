#CodeFores
#Lucky Division
#Python 3.6

import sys
a = int(input())
listOfNumbers = [4,7,44,47,74,77,444,447,474,477,777]

luckyNumber = False 
for j in listOfNumbers:
    if a % j == 0:
        luckyNumber = True
        break
    else:
        pass

if(luckyNumber):
    print("YES")
else:
    print("NO")
        
