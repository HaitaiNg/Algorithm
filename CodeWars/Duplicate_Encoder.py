def duplicate_encode(word):
    word = word.lower() 
    characterMap = {} 
    for i in word:
          if i in characterMap:
              characterMap[i] += 1 
          else:
              characterMap[i] = 1 
    returnString = "" 
    for j in word:
        if(characterMap[j]  > 1):
            returnString += ")"
        else:
            returnString += "("
    return returnString 
