#include <iostream> 
using namespace std;

// O(log(n) time) | O(log(n)) space 
int  binarySearch(int a[], int target, int start, int end)
{
    while(start < end) 
    {
        int mid = (start + end) / 2;
        if(a[mid] == target) return mid; 
        if(a[mid] > target) end = mid - 1;
        else start = mid + 1; 
    }
    return -1; 
}

int main() 
{
    int arr[] = {2,3,4,10,40,100,600,4520}; 
    int target = 100; 
    int result = binarySearch(arr, target, 0, sizeof(arr) - 1); 
    (result == -1) ? cout << "Element does not exist, return " << result 
                   : cout << "Element does exist, return " << result << endl;
}