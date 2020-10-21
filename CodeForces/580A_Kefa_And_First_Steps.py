#CodeForces
#Kefa and First Steps
#Python 3.6.5

import sys

n = int(input())
days = input()
days = days.split()

current_sum = 1
best_sum = 1 
for i in range(1, len(days), 1):
    if days[i] >= days[i-1]:
        current_sum += 1
        if current_sum > best_sum:
            best_sum = current_sum
    else:
        current_sum = 1
print(best_sum)
