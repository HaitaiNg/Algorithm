#CodeForces
#Anton and Polyhedrons

shapeMap = {}
shapeMap["I"] = 20
shapeMap["D"] = 12
shapeMap["O"] = 8
shapeMap["C"] = 6
shapeMap["T"] = 4 

total = 0 
for i in range(int(input())):
    shape = input() 
    total += shapeMap.get(shape[0])
print(total) 

    

