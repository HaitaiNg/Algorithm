def reverseWord(word):
    str = "" 
    for character in word:
        str = character + str
    return str 


def spin_words(sentence):
    listOfWords = sentence.split(' ') 
    returnSentence = "" 
    for i in listOfWords:
        if len(i) >= 5:
            returnSentence += reverseWord(i) 
        else:
            returnSentence += i
        returnSentence += " " 
    return returnSentence[:-1]