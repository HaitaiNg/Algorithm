#CodeForces
#Teams 
#Python 3.6.5 

import sys 

numberOfTests = int(input())
validProblems = 0 
while(int(numberOfTests) > 0): 
    problemGuesses = list( map(int, input().split()))
    count = 0 
    for guess in problemGuesses: 
        if guess == 1:
            count += 1 
    
    if count >= 2: 
        validProblems += 1 
    numberOfTests -= 1 
print(validProblems)
    
