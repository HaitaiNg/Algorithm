#CodeForces
#Hit The Lottery


def reduce_function(total, v, n):
    
    if total >= v :
        n += total // v
        total = total % v
    if total > 0 and v == 1:
        n += total
        total = 0 
    return [total, n] 
        
total = int(input())
n = 0
bills = [100,20,10,5,1]
while(bills and total > 0):    
    output = reduce_function(total, bills.pop(0), 0)
    total = output[0]
    n += output[1]
print(n)
    
