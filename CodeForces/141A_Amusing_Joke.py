#CodeForces
#Amusing Joke

guest = input()
residence = input()
pile = input()

guest = guest+residence 
guestMap = {}
for i in guest:
    i = i.lower() 
    if i in guestMap.keys():
        guestMap[i] += 1
    else:
        guestMap[i] = 1

residenceMap = {}
c = True 
for j in pile:
    j = j.lower() 
    if j in guestMap.keys():
        if(guestMap[j] - 1 == 0):
            del guestMap[j]
        else:
            guestMap[j] = guestMap[j] - 1 
    else:
        c = False
        break

if(len(guestMap.keys()) == 0 and c):
    print("YES")
else:
    print("NO") 
        
        
