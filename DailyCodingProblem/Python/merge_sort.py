#Best O(nlog(n)) time | O(nlog(n)) space
#Average O(nlog(n)) time | O(nlog(n)) space 
#Worst O(nlog(n)) time | O(nlog(n)) space 

def mergeSort(array):
    if len(array) <= 1:
        return array

    midpoint = len(array) // 2
    left = array[:midpoint]
    right = array[midpoint+1:]
    left = mergeSort(left)
    right = mergeSort(right)
    return merge(left, right)

def merge(left, right):
    result = [] 
    while( len(left) > 0 and len(right) > 0):
        if(left[0] <= right[0]):
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))

    while(left):
        result.append(left.pop(0))
    while(right):
        result.append(right.pop(0))
    return result 

arrayOne = [90,523,123,23,123,-23,2,55,0]
print(mergeSort(arrayOne))
arrayTwo = [10,15,25,1000,150,175,300]
print(mergeSort(arrayTwo))
