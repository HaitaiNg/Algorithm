#CodeForces
#Elephant
#Python 3.8.5

import sys
friend_distance = int(input())
number_of_steps = friend_distance // 5
if (friend_distance % 5 > 0):
    number_of_steps += 1
print(number_of_steps)
