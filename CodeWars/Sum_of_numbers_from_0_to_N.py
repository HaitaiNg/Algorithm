def show_sequence(n):
    if n == 0:
        return "0=0" 
    if n < 0:
        return str(n) + "<0"
        
    sum = 0 
    returnString = ""
    for i in range(0, n + 1):
        returnString += str(i) + "+"
        sum += i 
    returnString = returnString[:-1] 
    returnString += " = "  
    returnString += str(sum) 
    return returnString 
