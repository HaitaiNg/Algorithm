#include <iostream>
#include <vector>
#include <map>
#include <string>
using namespace std;


void helper(int digits, vector<string> phoneNumberMap, int index,
  vector<string> result, string array)
{
  if(index == std::to_string(digits).length())
  {
    result.push_back(array);
    cout << array << " \n";
    return;
  }

  string convertDigits = std::to_string(digits);
  char numberString = convertDigits.at(index);
  int number = numberString - '0';
  string candidates = phoneNumberMap[number];
  for(int i = 0; i < candidates.size(); i++)
  {
    cout << candidates[i];
    array.append(std::to_string(candidates[i]));
    helper(digits, phoneNumberMap, index + 1, result, array);
  }
}

vector<string> generateAllPossibleWordsFromPhoneDigits(int digits )
{
  vector<string> phoneNumberMap { "", "", "abc", "def", "ghi", "jkl",
                                      "mno", "pqrs", "tuv", "wxyz"};
  vector<string> result {};
  if(digits <= 0)
  {
    return {};
  }
  string array = "";
  helper(digits, phoneNumberMap, 0, result, array);
  return result;
}

int main()
{
  vector<string> pleaseWork = generateAllPossibleWordsFromPhoneDigits(23);
  for(string t: pleaseWork)
  {
    cout << t << "  ";
  }
  return 0;
}
