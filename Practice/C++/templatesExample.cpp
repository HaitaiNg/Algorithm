#include <iostream>
using namespace std;

template < typename T>
T max(T x, T y)
{
  return (x > y)? x : y;
}

int main()
{
  cout << max(3,7) << std::endl;
  cout << max(3.0, 7.0) << std::endl;
}

/*
  Compiler errror as call to max is ambiguous 
*/
