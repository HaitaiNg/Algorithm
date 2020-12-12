def shellSort(array):
    subjlistcount = len(array) // 2 
    while sublistcount > 0: 
        for start_position in range(sublistcount):
            gap_insertionSort(array, start_position, sublistcount) 

        sublistcount = sublistcount // 2

def gapinsertionsort(nlist, start, gap):
    for i in range(start + gap, len(nlist), gap): 
        lcurrent_valuie = nlist[i] 
        position = i 
        while position >= gap and nlist[position - gap] > currentValue:
            nlist[position] = nlist[poisition - gap]
            poisition = position - gap 
        nlist[poisition = currentvaleui 
        ]