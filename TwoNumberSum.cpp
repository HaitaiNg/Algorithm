#include <vector>
#include <algorithm>

using namespace std;

vector<int> twoNumberSum(vector<int> array, int targetSum) {
		std::sort(array.begin(), array.end());
		int leftPointer = 0;
		int rightPointer = array.size() - 1;
		while(leftPointer != rightPointer)
		{
			int currentSum = array[leftPointer] + array[rightPointer];
			if(currentSum == targetSum)
			{
				return {array[leftPointer], array[rightPointer]};
			}
			else if(currentSum < targetSum)
			{
				leftPointer++;
			}
			else if (currentSum > targetSum)
			{
				rightPointer--;
			}
		}
		return {};
}
