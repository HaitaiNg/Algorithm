#CodeForces 
#Next Round  
#Python 3.6.5 

import sys 

def invr(): 
    return(map(int,input().split()))


nAndK = list(invr())
n = nAndK[0]
k = nAndK[1]
scores = list(invr())
maxScore = scores[k-1]

studentsToNextRound = 0
for score in scores:
    if score > 0 and maxScore == 0:
        studentsToNextRound += 1 
    elif score >= maxScore and maxScore != 0:
        studentsToNextRound += 1
    else:
        pass
print(studentsToNextRound)
