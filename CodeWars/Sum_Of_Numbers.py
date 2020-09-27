def get_sum(a,b):
    start = min(a,b)
    end = max(a,b)
    
    if start == end:
        return start 
    
    cumulativeSum = 0 
    while(start <= end): 
        cumulativeSum += start 
        start += 1 
    return cumulativeSum 