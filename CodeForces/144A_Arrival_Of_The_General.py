#CodeForces
#Arrival Of The General
#Python 3.6.5

import sys


def general_sort(array, count):
    if(len(array) <= 1):
        return array

    maxHeight = max(soldiers)
    minHeight = min(soldiers) 
    minHeightIndex = len(array) - 1 - array[::-1].index(minHeight)
    for i in range( minHeightIndex, len(soldiers)):
        if(array[-1] == minHeight):
           break 
        if(array[i] > array[i - 1]):
            temp = array[i - 1]
            array[i - 1] = array[i]
            array[i] = temp
            count += 1 

    maxHeightIndex = array.index(maxHeight)
    count += maxHeightIndex
    print(count)
    
n = int(input())
soldiers = input()
soldiers = soldiers.split()
soldiers = [int(f) for f in soldiers]
general_sort(soldiers, 0)
