#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

/*
  Selection Sort
  Best : O(n^2) time | O(1) space
  Average : O(n^2) time | O(1) space
  Worst: O(n^2) time | O(1) space

  arr[] = 64 25 12 22 11

  // Find the minimum element in arr[0...4]
  // and place it at beginning
  11 25 12 22 64

  // Find the minimum element in arr[1...4]
  // and place it at beginning of arr[1...4]
  11 12 25 22 64

  // Find the minimum element in arr[2...4]
  // and place it at beginning of arr[2...4]
  11 12 22 25 64

  // Find the minimum element in arr[3...4]
  // and place it at beginning of arr[3...4]
  11 12 22 25 64 



*/
vector<int> selectionSort(vector<int> array)
{
  int n = array.size();
  // one by one move boundry of unsorted subarray
  for(int i = 0; i < n - 1; i++)
  {
    // find the maximum element in an unsorted array
    int minIndex = i;
    for( int j = i + 1; j < n; j++)
    {
      if(array[j] < array[minIndex])
      {
        minIndex = j;
      }
      // swap the found minimum element with the first element
      int temp = array[minIndex];
      array[minIndex] = array[i];
      array[i] = temp;
    }
  }
  return array;
}

void printArray(vector<int> array)
{
  for(auto element: array)
  {
    cout << element << " ";
  }
  cout << "\n";
}

int main()
{
  vector<int> testOne {5,2,1,4,10,50,23};
  printArray(selectionSort(testOne));
  vector<int> testTwo {100, 500,2032,42132142,1000,20,321321};
  printArray(selectionSort(testTwo));
  return 0;
}
