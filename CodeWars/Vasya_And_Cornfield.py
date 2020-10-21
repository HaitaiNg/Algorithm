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

grassHoppers = int(input())
while(grassHoppers > 0):
    gH_cord = input()
    gH_cord = gH_cord.split()
    x,y = int(gH_cord[0]), int(gH_cord[1])
    if ( x+y-d >= 0) and (x+y-2*n+d <= 0) and (x-y-d <= 0) and (x-y+d >= 0): 
        print("YES")
    else:
        print("NO") 
    
    grassHoppers -= 1 
