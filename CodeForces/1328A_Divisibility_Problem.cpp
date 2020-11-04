#include <algorithm>
#include <vector> 
#include <iostream> 

using namespace std;

int main()
{
    int n = 0, x = 0, y = 0, moves = 0; 
    cin >> n; 
    while(n > 0)
    {
         cin >> x >> y; 
        if(x % y == 0) cout << moves << endl; 
        else
        {
            int difference = x / y; 
            int output = (y * (difference + 1)) - x; 
            cout << output << endl;
        }
        n--;
    }
}