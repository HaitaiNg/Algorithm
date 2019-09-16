
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;
/* Basic string compression using the counts of repeated characters.
   Input: aabccccaaa = a2b1c5a3. String has only uppercase and lowercase letters
   Estimated run time I think is O(p + k^2) where p = original string and k is the number
   of character sequences
   */

string appendToReturnString(char character, int characterFrequency, string returnString)
{
  returnString += character;
  if(characterFrequency > 1)
  {
    returnString.append( std::to_string(characterFrequency));
  }
  return returnString;
}

string compressedString(string inputString)
{
  int characterFrequency = 0;
  char character = inputString[0];
  string returnString = "" ;

  for(int i = 0; i < inputString.size(); i++)
  {
    bool isEqual = character == inputString[i];
    if( isEqual)
    {
      characterFrequency++;
    }
    else if(!isEqual)
    {
      returnString = appendToReturnString(character, characterFrequency, returnString);
      characterFrequency = 1;
      character = inputString[i];
    }
    else
    {
      character = inputString[i];
    }
  }
  returnString = appendToReturnString( character, characterFrequency, returnString);
  return returnString;
}

int main()
{
  cout << "aabcccccaabbb" << " = " << compressedString("aabcccccaabbb") << endl;
  cout << "ttteeesssttt" << " = " << compressedString("ttteeesssttt") << endl;
  cout << "test" << " = " << compressedString("test") << endl;
  return 0;
}
