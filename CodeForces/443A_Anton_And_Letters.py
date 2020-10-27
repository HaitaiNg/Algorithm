#CodeForces
#Anton And Letters
#Python 3.7

chars = input()
if chars == "{}" :
    print("0")
else:
    chars = chars[1:-1]
    chars = chars.split(',')

    setOfChars = set()
    left= 0
    right = len(chars) - 1
    while(left<= right):
        lw = chars[left].strip()
        rw = chars[right].strip()
        if lw not in setOfChars:
            setOfChars.add(lw)
        if rw not in setOfChars:
            setOfChars.add(rw)
        left += 1
        right -= 1
    print(len(setOfChars))
    
    
