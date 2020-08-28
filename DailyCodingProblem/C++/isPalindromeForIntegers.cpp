#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

bool isPalindrome(int x)
{
	if(x<0 || (x > 0 && x % 10 == 0))
		return false;
	int temp = 0;
	while(temp < x && temp < x / 10) {
		temp *= 10;
		temp += x % 10; 
		x /= 10;
	}
	return temp == x || temp == x/10; 
}

int main()
{
	cout << isPalindrome(121) << "\n"; 
}
