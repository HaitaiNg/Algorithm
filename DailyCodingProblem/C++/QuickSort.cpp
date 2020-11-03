#include <vector>
#include <iostream> 

using namespace std; 


vector<int> quickSort( vector<int> array, int start, int end)
{
    int pivot = array[start]; 
    int low = start + 1; 
    int high = end; 
    while(true)
    {
        while(low <= high and array[high] >= pivot)
        {
            high--;
        }
        while(low <= high and array[low] <= pivot)
        {
            low++; 
        }
        if(low <= high)
        {
            int temp = array[high];
            array[high] = array[low];
            array[low] = temp; 
        }
        else
        {
            break; 
        }
        
    }

    array[start], array[high] = array[high], array[low]; 



    return array; 
}


int main()
{
    vector<int> test {29,99,27,41,66,28,44,78,87,19,31,76,58,88,83,97,12,21,44};
    test = quicksort(test, 0, test.size() - 1); 
    for(auto e : test)
    {
        cout << e << " "; 
    }
    cout << endl; 
    
}