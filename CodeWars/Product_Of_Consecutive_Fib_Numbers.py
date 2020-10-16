def productFib(prod):
    first = 0 
    last = 1 
    multiplied = first * last 
    while(multiplied < prod):
        temp = last 
        last += first 
        first = temp 
        multiplied = first * last 
    return [first, last, multiplied == prod] 
