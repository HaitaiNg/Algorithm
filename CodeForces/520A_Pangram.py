#CodeForces
#Pangram

length = int(input())
char = input()
sets = set() 
for i in char:
    sets.add(i.lower())
if len(sets) == 26:
    print("YES")
else:
    print("NO") 
