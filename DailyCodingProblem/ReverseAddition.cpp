/* The problem is as follows: choose a number, reverse its digits
and add it to the original. If the sum is not a palindrome (which means,
it is not the same number from left to right and right to left), repeat
this procedure

example:
195 + 591 = 786
786 + 687 = 1473
1473 + 3741 = 5214
5214 + 4125 = 9339 (palindrome)

Input: read lines from standard input
Output: number of iterations to compute the palindrome and the resuling palindrome

Source : Big 4 (Bank Interview Question)
 */

#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

int returnPalindrome(int number)
{
  int reverse = 0, remainder = 0;
  while(number != 0)
  {
    remainder = number % 10;
    reverse = reverse * 10 + remainder;
    number /= 10;
  }
  return reverse;
}

 bool palindromeAddition(int number, int i)
 {
   int sumValue = number + returnPalindrome(number);
   cout << number << " + " << returnPalindrome(number) << " = " << sumValue <<  "\n";
   if(sumValue == returnPalindrome(sumValue))
   {
     cout << "Sum Value "  << sumValue << " :: Iteration count " << i << "\n";
     return true;
   }
    i++;
    palindromeAddition(sumValue, i) ;
   return false;
 }

 int main()
 {
   palindromeAddition(200, 1);
   palindromeAddition(195, 1);
   palindromeAddition(12345, 1);
   palindromeAddition(121, 1);
 }
