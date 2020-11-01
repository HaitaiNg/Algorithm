#include <iostream> 
using namespace std;

// O(log(n)) time || O(log(n)) space 
int binarySearch(int arr[], int target, int start, int end)
{
    if(end >= 1)
    {
        int mid = start + (end - start) / 2;
        if(arr[mid] == target) return mid; 
        if(arr[mid] > target) return binarySearch(arr, target, start, mid); 
        else return binarySearch(arr, target, mid-1,  end); 
    }
    return -1; 
}

int main()
{
    int arr[] = {2,3,4,10,40,100,600,4520}; 
    int target = 4520; 
    int result = binarySearch(arr, target, 0, sizeof(arr) - 1); 
    (result == -1) ? cout << "Element does not exist, return " << result
                    : cout << "Element does exist, return " << result << endl; 

}