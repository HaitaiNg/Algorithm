'''
#Best: O(nlog(n)) time | O(log(n)) space
#Average: O(nlog(n)) time | O(log(n)) space
#Worst: O(n^2) time | O(log(n)) space


/* low  --> Starting index,  high  --> Ending index */
quickSort(arr[], low, high)
{
    if (low < high)
    {
        /* pi is partitioning index, arr[p] is now
           at right place */
        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
    }
}

# This function takes last element as pivot, places
# the pivot element at its correct position in sorted
# array, and places all smaller (smaller than pivot)
# to left of pivot and all greater elements to right
# of pivot
# Source: GeekForGeeks 

'''


def partition(array, low, high):
    i = (low - 1)
    pivot = array[high]
    for j in range(low, high):
        if array[j] <= pivot:
            i = i + 1
            array[i], array[j] = array[j], array[i]
    array[i + 1], array[high] = array[high], array[i + 1]
    print(array)
    return i+1 


def quickSort(array, low, high):
    if len(array) == 1:
        return array
    if low < high:
        pi = partition(array, low, high)
        quickSort(array, low, pi - 1)
        quickSort(array, pi + 1, high)
        

array = [100,23,2,523,12323,122,5]
quickSort(array, 0, len(array) - 1)
print(array) 
