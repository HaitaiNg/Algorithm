#CodeForce
#TwoGram

n = int(input())
char = list(input()) 
c_map = {}
for i in range(1, n, 2):
    key =  char[i-1]+char[i] 
    if key in c_map.keys():
        c_map[key] += 1
    else:
        c_map[key] = 1

for j in range(0, n - 1,):
    key= char[j]+char[j+1]
    if key in c_map.keys():
        c_map[key] += 1
    else:
        c_map[key] = 1

maxValue = -1
rk = -1 
for k, v in c_map.items():
    maxValue = max(maxValue, v)
    if( v == maxValue):
        rk = k
print(rk) 
