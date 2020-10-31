#CodeFroces
#Games

n = int(input())
totalGames = n * (n - 1 )

home = []
guest = [] 
for i in range(0, n):
    game = input().split()
    home.append(int(game[0]))
    guest.append(int(game[1]))


count = 0 
for i in home:
    for j in guest:
        if i == j:
            count += 1
print(count) 
