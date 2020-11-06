#This for some reason fails test 7? 
#Unsure because when I try an debug it locally, I get the expected output
#Weird

import sys 
n = input()
values = sys.stdin.readline()

values = values.split()
values = [int(i) for i in values] 

pos = 1 
rankMap = {} 

for i in values: 
    if i in rankMap.keys():
        rankMap[i].append(pos) 
    else:
        rankMap[i] = [] 
        rankMap[i].append(pos)
    pos +=1 


listOfResults = [] 
for k, v in rankMap.items():
    if(k == 1):
        c = v 
        while(c):
            temp = []
            temp.append(str(c.pop(0)))
            listOfResults.append(temp)
    if(k == 2 or k == 3): 
        c = v
        i = len(listOfResults)  
        while(c):
            if(i == 0):
                break 
            else:
                listOfResults[i - 1].append(str(c.pop(0)))
            i -= 1

summ = 0
for j in listOfResults:
    if len(j) == 3:
        summ += 1

print(summ)
for k in listOfResults:
    if(len(k)) == 3: 
        print(' '.join(k))

