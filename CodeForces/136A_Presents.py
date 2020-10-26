#CodeForces
#Presents
#Python 3.6.5

n = int(input())
presents = input().split()
presents = [int(f) for f in presents]

#for i, v in enumerate(p)
#   d[v] = i + 1 


d = {}
for i in range(0, n, 1):
    d[presents[i]] = i + 1 
output = "" 
for i in range(0, n, 1):
    output += str(d[i+1]) + " "
print(output)



