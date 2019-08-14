#include <algorithm>
#include <iostream>
#include <vector>
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

/* Binary Search
 * O(log(n)) time | O(1) space
 */
int binaryHelper(vector<int> array, int target, int left, int right)
{
	while(left <= right)
	{
		int midpoint = (left + right)/2;
		if(array[midpoint] == target)
		{
			return midpoint;
		}
		else if( array[midpoint] > target)
		{
			right = midpoint - 1;
		}
		else if( array[midpoint] < target)
		{
			left = midpoint + 1;
		}
	}
	return -1;
}

int binarySearch(vector<int> array, int target) {
	return binaryHelper(array, target, 0, array.size() - 1);
}



/* Insertion Sort
 * Best : O(n) time | O(1) space
 * Average : O(n^2) time | O(1) space
 * Worst : O(n^2) time | O(1) space
 */
vector<int> insertionSort(vector<int> array);
void swap(int i , int j , vector<int> *array);

void swap(int i , int j , vector<int> *array)
{
	int temp = array->at(j);
	array->at(j) = array->at(i);
	array->at(i) = temp;
}


vector<int> insertionSort(vector<int> array) {
  if(array.empty())
	{
		return {};
	}
	for(int i = 1; i < array.size(); i++)
	{
		int j = i;
		while(j > 0 && array[j] < array[j-1])
		{
			swap(j , j-1, &array);
			j -= 1;
		}
	}
	return array;
}



/* Selection Sort
 * Best : O(n^2) time | O(1) space
 * Average : O(n^2) time | O(1) space
 * Worst: O(n^2) time | O(1) space
 */
vector<int> selectionSort(vector<int> array) {
          int n = array.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
		return array;
}
