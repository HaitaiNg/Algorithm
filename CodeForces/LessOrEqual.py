#CodeForces
#Less Or Equal

n_k = input().split()
n = int(n_k[0])
k = int(n_k[1])
c = input().split()
c = [int(f) for f in c]
c.sort()
k -= 1

if(k < 0):
    if c[0] > 1:
        print("1")
    else:
        print("-1")
    exit()

if(c[k] == c[k +1]):
    print("-1")
else:
    print(c[k])
    
        
