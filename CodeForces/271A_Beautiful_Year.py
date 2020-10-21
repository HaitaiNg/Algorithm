#CodeForces
#Beautiful Year
#Python 3.6.5


def isBeautiful(year):
    numberSet = set()
    for i in year:
        if i in numberSet:
            return isBeautiful( str(int(year) + 1))
        else:
            numberSet.add(i)
    print(year) 



import sys
year = int(input())
isBeautiful(str(year + 1))
