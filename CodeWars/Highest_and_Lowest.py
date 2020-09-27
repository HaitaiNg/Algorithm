import sys 

def high_and_low(numbers):
    splitNumbers = numbers.split(" ")
    currentMin = sys.maxsize
    currentMax = -sys.maxsize - 1
    for i in splitNumbers:
        number = int(i) 
        if(currentMin > number):
            currentMin = number 
        if(currentMax < number):
            currentMax = number 
    return str(currentMax) + " " + str(currentMin)