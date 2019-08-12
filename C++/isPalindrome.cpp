

#include <iostream>
#include <algorithm>
using namespace std;


string removeSpaces(string str)
{
	str.erase(remove(str.begin(), str.end(), ' '), str.end());
	return str;
}

bool isPalindrome(string str) {

	if(str.length() == 0)
	{
		return true;
	}

	str = removeSpaces(str);
  int leftPointer = 0;
	int rightPointer = str.length() - 1;
	while((leftPointer <= rightPointer))
	{
		if( str.at(leftPointer) != str.at(rightPointer))
		{
			return false;
		}
		leftPointer++;
		rightPointer--;
	}
	return true;
}

int main()
{
	cout << isPalindrome("hannah") << "\n";
	cout << isPalindrome("nursesrun") << "\n";
	cout << isPalindrome("madam") << "\n";
	cout << isPalindrome("amore roma") << "\n";
	cout << isPalindrome("borrow or rob") << "\n";
	cout << isPalindrome("fail") << "\n";
	return 0;
}
