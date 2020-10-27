#CodeForces
#IQ Test
#Python 3.7

n = int(input())
j = 1
z = input().split() 

evenCount = 0
lastEven = -1; lastOdd = -1
j = 1 
for i in z:
    num = int(i)
    if(num % 2 == 0):
        lastEven = j
        evenCount += 1
    else:
        lastOdd = j
        evenCount -= 1
    j += 1 

if(evenCount > 0):
    print(lastOdd)
else:
    print(lastEven) 
