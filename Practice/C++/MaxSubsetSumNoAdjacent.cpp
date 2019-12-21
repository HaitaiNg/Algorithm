// Use dynamic programming
// input = [ 7, 10, 12, 7, 9 , 14]
// output = 7 + 12 + 14 = 33

// Build an array dynamically
#include <vector>
#include <algorithm>

// O(1) space | O(n) time : length to parse through the array
using namespace std;
int maxSubsetSumNoAdjacent(vector<int> array)
{
  if (array.size() == 0)
  {
    return 0;
  }
  else if (array.size() == 1)
  {
    return array[0];
  }

  int second = array[0];
  int first = max(array[0], array[1]);
  for(int i = 2; i < array.size(); i++)
  {
    int current = max(first, second + array[i]);
    second = first;
    first = current;
  }
  return first;
}
