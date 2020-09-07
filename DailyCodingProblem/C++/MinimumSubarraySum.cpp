// Fail run time
#include <algorithm>
#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
class Solution
{
	public:
		int sumSubarrayMins(vector<int>& A)
{	
	int minSum = 0;
	for(int element = 0; element < A.size(); element++)
	{
	vector<int> subArray; 
	for(int j = element; j < A.size(); j++)
	{
		subArray.push_back(A[j]); 
	minSum += *min_element(subArray.begin(), subArray.end()); 

	}

	}
	return minSum; 
}
}; 
