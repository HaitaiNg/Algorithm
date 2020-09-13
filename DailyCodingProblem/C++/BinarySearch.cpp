#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

// O(log(n)) time | O(log(n)) space
int binarySearch(vector<int> array, int target, int left, int right)
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
	return binarySearch(array, target, 0, array.size() - 1);
}

