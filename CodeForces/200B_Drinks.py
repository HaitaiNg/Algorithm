#CodeForces
#Drinks
#Python 3.7.2

import sys

n = int(input())
drink_percentages = input()
drink_percentages = drink_percentages.split()
drink_percentages = [int(i) for i in drink_percentages]
totalPercentage = n * 100
cumulativeSum = sum(drink_percentages) / float(totalPercentage)
cumulativeSum *= 100
print(round(cumulativeSum, 4))
