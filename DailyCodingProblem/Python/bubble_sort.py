#Best O(n) time | O(1) space
#Average O(n^2) time | O(1) space
#Worst O(n^2) time | O(1) space

def bubbleSort(array):
    if len(array) == 0:
        return array
    
    isSorted = True 
    for i in range(1, len(array)):
        if(array[i-1] > array[i]):
            tmp = array[i] 
            array[i] = array[i-1] 
            array[i-1] = tmp 
            isSorted = False 
        else:
            pass 

    if(isSorted == False):
        bubbleSort(array) 
    
    print(array)

arrayOne = [90,523,123,23,123,-23,2,55,0]
bubbleSort(arrayOne)
arrayTwo = [10,15,25,1000,150,175,300]
bubbleSort(arrayTwo)

