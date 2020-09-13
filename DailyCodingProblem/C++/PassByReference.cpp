// arguments passed by value and reference
 #include <iostream>
using namespace std;

void duplicate( int& a, int& b, int& c)
{
 a *= 2;
 b *= 5;
 c *= 10;
}

int main()
{
int a = 10, b = 2, c = 30;
duplicate(a, b c); // a = 20, b = 10, c = 300
return 0;
}
