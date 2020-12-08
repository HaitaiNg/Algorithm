#Best O(n) time | O(1) space 
#Average O(n^2) time | O(1) space 
#Worst O(n^2) time | O(1) space
def insertionSort(array): 
    for i in range(1, len(array)):
        j = i
        while j > 0 and array[j] < array[j-1]:
            tmp = array[j] 
            array[j] = array[j-1]
            array[j-1] = tmp 
            j -= 1
    print(array) 

insertionSort([90,523,123,23,123,-23,2,55,0])
insertionSort([10,15,25,1000,150,175,300])

