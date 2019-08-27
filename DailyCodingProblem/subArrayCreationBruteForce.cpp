#include <vector>
#include <algorithm>
#include <iostream> 
using namespace std;

int main()
{
	vector<int> test { 4,3, 1, 2, 5, 6, 9, 8}; 
	for(int i = 0; i < test.size(); i++)
	{
		vector<int> subArray; 
		for(int j = i; j < test.size(); j++)
		{
			subArray.push_back(test[j]); 
		}
		for(int k : subArray)
		{
			cout << k << " "; 
		}
		cout << "\n"; 

	}

	return 0; 
}
