// CodeForces
// Theatre Square 
// GNU C++ 17 

#include <iostream>
using namespace std; 

int main()
{
    long long n = 0, m = 0, a = 0;
    cin >> n >> m >> a; 

    long long x = n / a; 
    long long y = m / a; 
    if(n % a != 0) x++; 
    if(m % a != 0) y++; 
    cout << x*y << endl; 
}