#include <vector>
#include <iostream>
using namespace std;

// Recursive solution
// O(n*n^2) time | O(n*n^2) space
vector<vector<int> > powerset(vector<int> array) {
  vector<vector<int>> subsets {{}};
	for(int element: array)
	{
		int length = subsets.size();
		cout << length << "  " << "\n";
		for(int j = 0; j < length; j++)
		{
			vector<int> currentSubset = subsets[j];
			currentSubset.push_back(element);
			subsets.push_back(currentSubset);
		}
	}
	return subsets;
}

/// ------------------------- \\

#include <vector>
#include <iostream>
#include <cstddef>
using namespace std;

// Iterative solution
// O(n*n^2) time | O(n*n^2) space 
vector<vector<int>> powersetHelper(vector<int> array, int index)
{
	if(index < 0)
	{
		return {{}};
	}
	int element = array[index];
	vector<vector<int>> subset = powersetHelper(array, index - 1);
	int length = subset.size();
	for(int i = 0; i < length; i++)
	{
		vector<int> currentSubset = subset[i];
		currentSubset.push_back(element);
		subset.push_back(currentSubset);
	}
	return subset;
}


vector<vector<int> > powerset(vector<int> array) {
	return powersetHelper(array, array.size() - 1);
}
