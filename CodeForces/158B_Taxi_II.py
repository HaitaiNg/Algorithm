#CodeForces
#Taxi

import sys
n = int(input())
d = input().split()
d = [int(i) for i in d]
numberMap = {}

groups = 0 
for i in d:
    if i == 4:
        groups += 1
    elif i in numberMap.keys():
        numberMap[i] += 1
    else:
        numberMap[i] = 1

if 3 in numberMap.keys() and 1 in numberMap.keys():
    groups += min(numberMap.get(3), numberMap.get(1))
    if(numberMap.get(3) < numberMap.get(1)):
        numberMap[1] -= numberMap.get(3)
        del numberMap[3]
    else:
        numberMap[3] -= numberMap.get(1)
        del numberMap[1]
if 3 in numberMap.keys() and 1 not in numberMap.keys():
    groups += numberMap[3]
    del numberMap[3]

total = 0 
for key, value in numberMap.items():
    total += (key * value)
while(total >=  4):
    total -= 4
    groups += 1

if(total < 4 and total > 0):
    groups += 1
print(groups)

