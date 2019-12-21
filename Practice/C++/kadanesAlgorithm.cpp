#include <vector>
#include <iostream> 
using namespace std;

// O(n) tume | O(1) space
int kadanesAlgorithm(vector<int> array) {
  int maxSoFar = array[0], maxEndingHere = array[0];
	for(int i = 1; i < array.size(); i++)
	{
		maxEndingHere = max( array[i] , maxEndingHere + array[i]);
		maxSoFar = max(maxSoFar, maxEndingHere);
	}
	return maxSoFar;
}

int main()
{
  vector<int> testOne {-2, -3, 4, -1, -2, 1, 5, -3};
  cout << "Maximum contiguous sum is " << kadanesAlgorithm(testOne) << "\n"; // 7
}
