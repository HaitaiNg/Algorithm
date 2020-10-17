#CodeForces
#Vasya And Cornfield
#Python 3.7.2

import sys
n_and_d = input()
n_and_d = n_and_d.split()
n, d = int(n_and_d[0]), int(n_and_d[1])

rt_1 = (0, d)
rt_3 = (n,n-d)

rt_4 = (n-d,n)
rt_2 = (d,0)
 

print(rt_1)
print(rt_3)

print(rt_4)
print(rt_2)



#need to calculate the slope between the two lines
#then calculate all the coordinates between them


grassHoppers = int(input())
while(grassHoppers > 0):
    gH_cord = input()
    gH_cord = gH_cord.split()
    
    grassHoppers -= 1 
