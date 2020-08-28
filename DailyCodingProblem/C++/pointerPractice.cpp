#include <algorithm>
#include <iostream>

using namespace std;

int main()
{
  int x[] = { 'a','b','c','d','e','f','g','h'};
  int *ptr, y;
  ptr = x + 4;
  y = ptr - x;
  cout << y << endl;
  return 0;
}
