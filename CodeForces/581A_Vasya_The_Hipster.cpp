#include <algorithm>
#include <iostream>
#include <vector>

using namespace std; 

int main()
{
    int a = 0, b=0;
    cin >> a >> b; 
    int differnce = std::min(a, b); 
    a -= differnce;
    b -= differnce; 
    cout << differnce << " " << (a+b)/2 << endl;


}