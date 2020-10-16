def sum_pairs(ints, s):
    if(len(ints) < 2):
        return None 
    newSet = set() 
    newSet.add(ints[0])
    for i in ints[1:]:
        complement = s - i
        if complement in newSet:
            return [complement, i] 
        else:
            newSet.add(i) 
    return None
