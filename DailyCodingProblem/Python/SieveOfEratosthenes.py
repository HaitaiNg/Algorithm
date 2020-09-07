def isPrime(number):
    if(number <= 1):
        return False
    if(number <= 3):
        return True
    if(number % 2 == 0 or number % 3 == 0):
        return False
    i = 5
    while(i * i <= number):
        if(number % i == 0 or n % (i + 2) == 0):
            return False
        i = i + 6
    return True


def sieve(number):
    x = 0
    returnList = []
    while(x <= number):
        if(isPrime(x)):
            returnList.append(x)
        else:
            pass
        x += 1
    return returnList

print(sieve(10))
