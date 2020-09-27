import math

def circleArea(r):
    if(isinstance(r, int) == False):
        return False 
    if(r <= 0):
        return False 
    
    areaOfACircle = math.pi * r * r 
    return float("{:.2f}".format(areaOfACircle))