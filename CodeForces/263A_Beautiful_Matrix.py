#CodeForces
#Beutiful Matrix
#Python 3.6.5

import sys
matrix = []
n = 5; x = 0 
centerPoint = [2,2]
one_coordinates = []
while(n > 0):
    matrix_line = input()
    matrix_line = matrix_line.split()
    matrix_line = [int(f) for f in matrix_line]
    if 1 in matrix_line:
        one_coordinates.append(x)
        one_coordinates.append(matrix_line.index(1)) #matrix_line.index(1) : y coordinate
    x += 1
    n -= 1 

numberOfMoves = 0

#find X difference
if one_coordinates[0] == centerPoint[0]:
    pass
else:
    numberOfMoves += abs(one_coordinates[0] - centerPoint[0])

if one_coordinates[1] == centerPoint[1]:
    pass
else:
    numberOfMoves += abs(one_coordinates[1] - centerPoint[1])

print(numberOfMoves)




    
