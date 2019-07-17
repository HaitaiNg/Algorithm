

#include <iostream>
using namespace std;

bool isPalindrome(string str) {

	if(str.length() == 0)
	{
		return true;
	}

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
