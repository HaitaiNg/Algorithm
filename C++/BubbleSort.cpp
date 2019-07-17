#include <vector>
#include <iostream>
using namespace std;

vector<int> bubbleSort(vector<int> array) {
	int i, j = 0;
	for(i = 0; i < array.size() - 1; i++)
	{
		for( j = 0; j < array.size() - i - 1; j++)
		{
			if(array[j] > array[j + 1])
			{
				int temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp;
			}
		}
	}
  return array;
}
