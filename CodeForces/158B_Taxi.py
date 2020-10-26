#CodeForces
#Taxi

#NOTE: This solution times out and has a
# TIME LIMIT EXCEEDED error. Please see 158B_Taxi_II.py

import sys 
n = int(input())
children = input().split()
children = [int(i) for i in children] 
children.sort()
children.reverse() 
groups = []

four_count = 0 
for i in children:
    if i == 4:
        four_count += 1
    else:
        break 
if(four_count > 0):        
    children = children[four_count:]
 
if(len(children) > 0 and 3 in children):
    while(3 in children):
        three = children.pop(0) 
        if 1 in children:
            groups.append(three + children.pop())    
        else:
            groups.append(three)
            
if(len(children) > 0): 
    currentCount = 0 
    for i in children:
        if(currentCount + i > 4):
            groups.append(currentCount)
            currentCount = i 
        elif(currentCount + i == 4):
            groups.append(currentCount + i)
            currentCount = 0
        else:
            currentCount += i 
    if(currentCount != 0):
        groups.append(currentCount) 

print(len(groups) + four_count) 
