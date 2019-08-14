#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;


/* Bubble sort
  Best: O(n) time | O(1) memory
  Averae: O(n^2) time | O(1) space
  Worst: O(n^2) time | O(1) space
*/
vector<int> bubbleSort(vector<int> array)
{
  int i, j = 0;
  for(i = 0; i < array.size() - 1; i++)
  {
    for( j = 0; j < array.size() - i - 1; j++)
    {
      if(array[j] > array[j + 1])
      {
        int temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
      }
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
  printArray(bubbleSort(testOne));
  vector<int> testTwo {100, 500,2032,42132142,1000,20,321321};
  printArray(bubbleSort(testTwo));
  return 0;
}
