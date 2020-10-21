#CodeForces
#George and Accommodation
#Python 3.6.5

import sys
number_of_rooms = int(input())

count = 0 
while(number_of_rooms > 0):
    p_and_q = input().split()
    p, q = int(p_and_q[0]), int(p_and_q[1])
    if(q - p >= 2):
        count += 1 
    number_of_rooms -= 1
print(count)
