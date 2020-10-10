#CodeForces 
#Word Capitalization  
#Python 3.6.5 

import sys 

number_of_stones = int(input())
stones = input()
left = 0
right = 1
removals = 0 
while(left < right and right <= len(stones) - 1):
    if( stones[left] == stones[right]):
        removals += 1
    else:
        pass
    left += 1
    right += 1 
print(removals)
