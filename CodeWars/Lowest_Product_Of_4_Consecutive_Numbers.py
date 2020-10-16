def lowest_product(input):
    if(len(input) < 4): 
        return "Number is too small"
    currentMinimum = int(input)
    startIndex = 0 
    x = str(input) 
    for i in str(input):
        currentValue = int(input)
        if(len(input) > startIndex + 3):
            currentValue = 1
            for j in x[startIndex:startIndex + 4]:
                currentValue *= int(j) 
        startIndex += 1
        if(currentMinimum > currentValue):
            currentMinimum = currentValue 
    return currentMinimum 
