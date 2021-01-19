def christmas_tree(height):
    result = [] 
    h = 0 
    maxLength = 0 
    while h < height: 
        row = ['*'] * (2*h+1) 
        h += 1 
        maxLength = max(maxLength, len(row)) 
        result.append(row) 
        
    rS = ""
    c = height - 1 
    for j in result: 
        rS += ' ' * c
        rS += ''.join(j)
        rS += ' ' * c
        if c != 0: 
            rS += '\n' 
        c -= 1 
        
    return rS
