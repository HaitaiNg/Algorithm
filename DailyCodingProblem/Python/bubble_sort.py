#Best O(n) time | O(1) space
#Average O(n^2) time | O(1) space
#Worst O(n^2) time | O(1) space

def bubbleSort(array):

    if(len(array) == 1):
        return array 
    
    isSorted = 0
    for i in range(1, len(array), 1):
        if( array[i] < array[i-1]):
            temp = array[i-1]
            array[i-1] = array[i]
            array[i] = temp
        else:
            isSorted += 1 

    if(isSorted == len(array) - 1 ):
        print(array)
    else:
        bubbleSort(array)


arrayOne = [90,523,123,23,123,-23,2,55,0]
bubbleSort(arrayOne)
arrayTwo = [10,15,25,1000,150,175,300]
bubbleSort(arrayTwo)

