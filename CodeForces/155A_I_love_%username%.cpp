#include <vector>
#include <algorithm>
#include <iostream>

using namespace std; 

int main()
{
    int n, points; 
    cin >> n >> points;

    int min(points), max(points), amazing(0); 
    while(n--)
    {
        cin >> points; 
        if(points < min)
        {
            amazing++; 
            min = points;
        }
        if(points > max)
        {
            amazing++; 
            max = points;
        }
    }
    cout << amazing << endl;
    return 0;
    
}