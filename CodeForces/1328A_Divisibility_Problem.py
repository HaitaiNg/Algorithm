#CodeForces
#Divisibility Problem

for _ in range(int(input())):
    a_b = list(map(int, input().split()))
    a, b = a_b[0], a_b[1]

    moves = 0
    while(a % b != 0):
        moves += (a % b)
        a += (a % b) 
    print(moves) 
    
