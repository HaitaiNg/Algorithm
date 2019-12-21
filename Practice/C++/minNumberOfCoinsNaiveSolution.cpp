#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
#include <cstdlib>
using namespace std;

//I was trying to solve this in O(n) time
int numberOfCoinHelper(int target, int currentCoin)
{
  if(target % currentCoin == 0)
  {
    return 0;
  }
  else if( currentCoin > target)
  {
    return -1;
  }
  return target / currentCoin;
}

int minNumberOfCoinsForChange(int n, vector<int> denoms) {
	sort(denoms.begin(), denoms.end());
	int numberOfCoins = 0;
  int target = n;

	for(int i = denoms.size() - 1; i >= 0; i--)
	{
		int currentCoin = denoms[i];
    int numberOfCoinHelperValue = numberOfCoinHelper(target, currentCoin);
    if (numberOfCoinHelperValue == -1 )
    {
      // do nothing
    }
    else if(numberOfCoinHelperValue == 0)
    {
      if(numberOfCoins == 0) //< base case
      {
        return target / currentCoin;
      }
      return numberOfCoins + (target / currentCoin);
    }
    else
    {
      numberOfCoins = numberOfCoins + numberOfCoinHelperValue;
      target = abs(target - (numberOfCoins * currentCoin));
    }
	}
  return -1;
}

int main()
{
  vector<int> testOne {1,5,10,25}; //< this is one was a special case.
  vector<int> testTwo {39,45,40,4,1};
  vector<int> testThree {39,45,40,4,1,60,75};
  cout << minNumberOfCoinsForChange(25, testOne) << "\n";
  cout << minNumberOfCoinsForChange(50, testOne) << "\n";
  cout << minNumberOfCoinsForChange(30, testOne) << "\n";
  cout << minNumberOfCoinsForChange(100, testOne) << "\n";
  cout << minNumberOfCoinsForChange(10000, testOne) << "\n";
  cout << minNumberOfCoinsForChange(10, testOne) << "\n";
  cout << minNumberOfCoinsForChange(15, testOne) << "\n";
  cout << minNumberOfCoinsForChange(7, testOne) << "\n";
  cout << minNumberOfCoinsForChange(9, testOne) << "\n";
  cout << minNumberOfCoinsForChange(135, testTwo) << "\n";
  cout << minNumberOfCoinsForChange(135, testThree) << "\n";
}


/* AlgoExperSolution

#include <vector>
#include <climits>
using namespace std;

// O(nd) time | O(n) space 
int minNumberOfCoinsForChange(int n, vector<int> denoms)
{
  vector<int> numOfCoins( n+1, INT_MAX);
  numOfCoins[0] = 0;
  int toCompare = 0;
  for(int denom: denoms)
  {
    for(int amount = 0; amount < numOfCoins.size(); amount++)
    {
      if(denom <= amount)
      {
        if(numOfCoins[amount - denom] == INT_MAX)
        {
          toCompare = numOfCoins[amount - denom];
        }
        else
        {
          toCompare = numOfCoins[amount - denom] + 1;
        }
        numOfCoins[amount] = min(numOfCoins[amount], toCompare);
      }
    }
  }
  return numOfCoins[n] != INT_MAX ? numOfCoins[n] : -1;
}



*/
