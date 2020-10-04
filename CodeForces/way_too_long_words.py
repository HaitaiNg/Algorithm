#Way Too Long Words     
import sys 

numberOfWords = int(input())
while(numberOfWords > 0): 
    readWord = str(raw_input()) 
    if( len(readWord) > 10):
        count = len(readWord[1:-2]) + 1 
        print(readWord[0] + str(count) + readWord[-1])
    else:
        print(readWord)
    numberOfWords -= 1 