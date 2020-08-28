#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

/* Insertion sort
   Best: O(n) time | O(1) space
   Average: O(n^2) time | O(1) space
   Worst: O(n^2) time | O(1) space
*/

vector<int> insertionSort(vector<int> array);
void swap(int i , int j , vector<int> *array);

void swap(int i , int j , vector<int> *array)
{
	int temp = array->at(j);
	array->at(j) = array->at(i);
	array->at(i) = temp;
}

vector<int> insertionSort(vector<int> array)
{
  if(array.empty())
  {
    return {};
  }
  for(int i = 1; i < array.size(); i++)
  {
    int j  = i;
    while(j > 0 && array[j] < array[j-1])
    {
      swap( j, j - 1, &array);
      j -= 1;
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
  printArray(insertionSort(testOne));
  vector<int> testTwo {100, 500,2032,42132142,1000,20,321321};
  printArray(insertionSort(testTwo));
  return 0;
}
