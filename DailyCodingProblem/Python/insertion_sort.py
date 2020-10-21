#Best O(N) time | O(1) space 
#Average O(n^2) time | O(1) space 
#Worst O(n^2) time | O(1) space


def insertionSort(array):
    for i in range(1, len(array), 1):
        if(array[i] < array[i-1]):
            for j in range(0, i, 1): #comparing the predecessors 
                if(array[i] < array[j]):
                    temp = array[j]
                    array[j] = array[i]
                    array[i] = temp 
                else:
                    pass 

    print(array) 

arrayOne = [90,523,123,23,123,-23,2,55,0]
insertionSort(arrayOne)
arrayTwo = [10,15,25,1000,150,175,300]
insertionSort(arrayTwo)
