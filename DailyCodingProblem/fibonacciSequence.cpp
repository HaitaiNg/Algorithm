#include <vector>

using namespace std;
class Solution{
	public:
		int fib(int N){
			vector<int> test {0,1}; 
			for(int i = 2; i <= N; i++)
			{
				int temp - test[0] + test[1];
				test[0] = test[1];
				test[1] = temp; 
			}
				return N >= 1 ? test[1] : 0;
			}
} 
