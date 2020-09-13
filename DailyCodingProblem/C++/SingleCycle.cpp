#include <vector>
using namespace std;

int getNextIndex(int currentIndex, vector<int> array);

// O(n) time | O(1) space - where n is the length of the input array
bool hasSingleCycle(vector<int> array)
{
  int numElementsVisited = 0;
  int currentIndex = 0;
  while(numElementsVisited < array.size())
  {
    if(numElementsVisited > 0 && currentIndex == 0)
    {
      return false;
    }
    numElementsVisited++;
    currentIndex = getNextIndex(currentIndex, array);
  }
  return currentIndex == 0;
}

int getNextIndex(int currentIndex, vector<int> array)
{
  int jump = array[currentIndex];
  int nextIndex = (currentIndex + jump) % (int) array.size();
  return nextIndex >= 0 ? nextIndex : nextIndex + array.size();
}
