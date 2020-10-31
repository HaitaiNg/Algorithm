#CodeForces
#Reverse Binary Strings

for _ in range(int(input())):
    n = int(input())
    s = list(input())
    s1 = []
    s2 = []
    count = 0
    for i in s:
        if len(s1) == 0 or i != s1[-1]:
            s1.append(i)
        elif len(s2) != 0 and i != s2[-1]:
            s1.append(s2.pop())
            s1.append(i)
        else:
            s2.append(i)
            count += 1
    #print(s1)
    print(count) 
        
