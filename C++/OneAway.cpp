#include <iostream>
#include <string>
using namespace std;

/* There are three types of edits that can be performed on a string.
 * Given two strings, determine if they are one or zero edits away */
bool oneEditReplace(string stringOne, string stringTwo)
{
  bool foundDifference = false;
  for(int i = 0; i < stringOne.size(); i++)
  {
    if(stringOne[i] != stringTwo[i])
    {
      if(foundDifference)
      {
        return false;
      }
      else
      {
        foundDifference = true;
      }
    }
  }
  return false;
}


bool oneEditInsert(string stringOne, string stringTwo)
{
  int indexOne = 0, indexTwo = 0;
  while(indexTwo < stringTwo.size() && indexOne < stringOne.size())
  {
    if(stringOne[indexOne] != stringTwo[indexTwo])
    {
      if(indexOne != indexTwo)
      {
        return false;
      }
      indexTwo++;
    }
    else
    {
      indexOne++;
      indexTwo++;
    }
  }
  return true;
}

bool oneEditAway(string stringOne, string stringTwo)
{
  if(stringOne == stringTwo)
  {
    return true;
  }
  if(stringOne.size() == stringTwo.size())
  {
    return oneEditReplace(stringOne, stringTwo);
  }
  else if(stringOne.size() + 1 == stringTwo.size())
  {
    return oneEditInsert(stringOne, stringTwo);
  }
  else if (stringOne.size() - 1 == stringTwo.size())
  {
    return oneEditInsert(stringTwo, stringOne);
  }
  return false;
}

int main()
{
	cout << oneEditAway("mockTest", "mock") << endl;
  cout << oneEditAway("yess", "yes") << endl;
  cout << oneEditAway("yes", "yes") << endl;
  cout << oneEditAway("no", "n") << endl;
	return 0 ;
}
