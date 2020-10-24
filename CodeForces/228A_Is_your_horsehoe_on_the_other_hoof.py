#CodeForces
#Is your horseshoe on the other hoof?
#Python 3.6.5

import sys

hooves = input()
hooves = hooves.split()
hooves = [int(f) for f in hooves]
hooves_set = set()

for i in hooves:
    hooves_set.add(i)

print(4 - len(hooves_set))
