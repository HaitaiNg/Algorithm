#include <iostream>
using namespace std;

int maxSubArraySum(int a[], int size)
{
	int maxSoFar = a[0];
	int currentMax = a[0];
	for(int i = 0; i < size; i++)
	{
	currentMax = max( a[i], currentMax + a[i]);
	maxSoFar = max(maxSoFar, currentMax);
	}
	return maxSoFar;
}

int main()
{
	int a[8] { -2,-3,4,-1,2,1,5,-3};
	int n = sizeof(a) / sizeof(a[0]);
	int maxSum = maxSubArraySum(a, n);
	cout << maxSum << "\n";
	return 1;
}
