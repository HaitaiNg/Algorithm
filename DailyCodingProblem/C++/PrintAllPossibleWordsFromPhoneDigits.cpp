#include <iostream>
#include <vector>
#include <map>
#include <string>
using namespace std;


vector<string> helper(int digits, vector<string> phoneNumberMap, int index,
  vector<string> result)
{
  string convertDigits = std::to_string(digits);
  char numberString = convertDigits.at(index);
  int number = numberString - '0';
  string candidates = phoneNumberMap[number];
  cout << number << "  " << candidates << "\n"; 
  result.push_back(candidates); 
  if(index != convertDigits.size() - 1)
	{
		result = helper( digits, phoneNumberMap, index + 1, result ); 
	}
  return result; 
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
  result = helper(digits, phoneNumberMap, 0, result);
  return result;
}

int main()
{
  vector<string> testOne  = generateAllPossibleWordsFromPhoneDigits(879);
  std::string s; 
  for(const auto &piece : testOne) s += piece; 
  cout << s << "\n"; 
  return 0;
}
