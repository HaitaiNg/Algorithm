#CodeForces
#Tram
#Python 3.6.5

import sys
number_of_stops = int(input())
passengerCount = 0
currentMaximum = float('-inf') 
while(number_of_stops > 0):
    stop = input()
    stop = stop.split()
    leaving, boarding = int(stop[0]), int(stop[1])
    passengerCount += boarding
    passengerCount -= leaving
    currentMaximum = max(passengerCount, currentMaximum) 
    number_of_stops -= 1
print(currentMaximum)
