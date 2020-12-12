from random import randint 
def quicksort(array):
    if len(array) < 2: 
        return array 
    low, same, high = [], [], [] 
    pivot = array[randint(0, len(array) - 1)]
    for item in array:
        if item < pivot:
            low.append(item)
        elif item == pivot:
            same.append(item)
        elif item > pivot:
            high.append(item)
    return quicksort(low) + same + quicksort(high) 


array = [29,99,27,41,66,28,44,78,87,19,31,76,58,88,83,97,12,21,44]
print(quicksort(array))