#include <vector>
#include <algorithm>
#include <iostream>

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

// Print out the vector contents returnd from TwoNumberSum
void printVector(vector<int> array, int sum)
{
	for(auto element: array)
	{
		cout << element << " ";
	}
	cout << "| target : " << sum << "\n";
}

int main()
{
	vector<int> returnVector = twoNumberSum( {10,20,30,40}, 50);
	printVector(returnVector, 50);
	vector<int> returnVectorTwo = twoNumberSum( {60,30,100,50,200}, 300);
	printVector(returnVectorTwo, 300);
	vector<int> returnVectorThree = twoNumberSum( {10,10,10,10,10}, 0);
	printVector(returnVectorThree, 0);

	return 0;
}
