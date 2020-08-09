def arrangeCoins(n):
    if n <= 1:
        return n 
    rowNumber = 1 
    while(n - rowNumber + 1 >= 0):
        n -= rowNumber
        rowNumber += 1 
        #print(n)
    return rowNumber 
print(arrangeCoins(3))
print(arrangeCoins(5))