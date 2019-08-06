
// how do you declare. pointer to an array of pointers to int

#include <iostream>
#include <stdio.h>
using namespace std;

class A1
{
public:
  int upper;
  int lower;
  A1 (int i ) : lower(i), upper(lower+1) {};
};


int main()
{
  A1 a(5);
  cout << a.lower << "  " << a.upper << endl;
  return 0;
}
