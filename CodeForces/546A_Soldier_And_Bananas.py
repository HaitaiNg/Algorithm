#CodeForces
#Soldir and Bananas 
#Python 3.6.5

import sys
user_input = input()
user_input = user_input.split()
user_input = [int(f) for f in user_input]

k = user_input[0]
n = user_input[1]
w = user_input[2]

totalCost = 0
count = 1 
while(w > 0):
    totalCost += k * (count)
    count += 1
    w -= 1

if(totalCost < n):
    print(0)
else:
    print(abs(totalCost - n))
