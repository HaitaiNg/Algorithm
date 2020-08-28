#include <vector>
#include <algorithm>
#include <iostream>
#include <cmath>

using namespace std;
// O(nlog(n) + mlog(m) time) | O(1) space
vector<int> smallestDifference(vector<int> arrayOne, vector<int> arrayTwo) {
  std::sort(arrayOne.begin(), arrayOne.end());
	std::sort(arrayTwo.begin(), arrayTwo.end());
	int leftPointer = 0;
	int leftPointerTwo = 0;
	int smallestDifference = INT_MAX;
	vector<int> returnVector;
	while(leftPointer < arrayOne.size() && leftPointerTwo < arrayTwo.size())
	{
		int difference = abs(arrayOne[leftPointer] - arrayTwo[leftPointerTwo]);
		if(difference == 0)
		{
			return {arrayOne[leftPointer], arrayTwo[leftPointerTwo]};
		}

		if(difference < smallestDifference)
		{
			smallestDifference = difference;
			returnVector = {arrayOne[leftPointer], arrayTwo[leftPointerTwo]};
		}

		if( arrayOne[leftPointer] > arrayTwo[leftPointerTwo])
		{
			leftPointerTwo++;
		}
		else if( arrayOne[leftPointer] < arrayTwo[leftPointerTwo])
		{
			leftPointer++;
		}
	}
	return returnVector;
}
