def heggeleggleggo(word):
    vowels = " aeiouAEIOU"; rS = "" 
    for j in word: 
        if j not in vowels:
            rS += j + "egg" 
        else:
            rS += j 
    return rS
