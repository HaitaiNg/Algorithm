/
#Three number sum (ideal algorithm)
# Sort the array
# Use two loops and iterate through the array
# Use Left pointer and Right pointer
# member variable (int currentSum = currentNumber + left + right)
#    check is ( currentSum = targetSum) ?
#      if(currentSum > targetSum) : move left pointer
#      else if (currentSum < targetSum) : move right pointer

#once you have an occurrence where currentSum == targetSum
#you have to move both pointers (left++, right--) to check if there are
#any values in between that equal to the targetSum

#O(n^2) time | O(n) space */

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<vector<int> > threeNumberSum(vector<int> array, int targetSum) {
	vector<vector<int>> triplets;
 	 sort( array.begin(), array.end());
	for(int i = 0; i < array.size() - 2; i++)
	{
		int left = i + 1;
		int right = array.size() - 1;
		while(left < right)
		{
			int currentSum = array[i] + array[left] + array[right];
			if(currentSum == targetSum)
			{
				vector<int> v { array[i], array[left], array[right]};
				triplets.push_back(v);
				left++;
				right--;
			}
			else if ( currentSum > targetSum)
			{
				right--;
			}
			else if (currentSum < targetSum)
			{
				left++;
			}
		}
	}
	return triplets;
}
