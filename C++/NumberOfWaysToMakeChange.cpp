/* Input: target value ($), Coin Demoniations [ array of coins]
  How many ways can you make change for the target value?

  Ex: $10, [ 1, 5, 10 , 25]
  There are 4 ways to make change for $10 : [ 1 x 10, 2 x 5, 1x5 + 5x1, 10 x 1]
  Dynamic programming problem */

  #include <algorithm>
  #include <vector>
  #include <cmath>

  using namespace std;

  int numberOfWaysToMakeChange(int n , vector<int> demons)
  {
    vector<int> ways(n + 1, 0);
    ways[0] = 1;
    for(int denom: denoms)
    {
      for(int amount = 1; amount < n + 1; amount++)
      {
        if(denom <= amount)
        {
          ways[amount] += ways[amount - denom];
        }
      }
    }
    return ways[n];
  }
