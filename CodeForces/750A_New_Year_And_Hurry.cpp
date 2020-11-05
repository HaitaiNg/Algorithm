#include <iostream>
#include <vector> 
#include <algorithm>

using namespace std;

int main()
{
    int n = -1, k = 0; 
    cin >> n >> k; 

    int remainingTime = 240 - k;
    int i = 0; 
    while(remainingTime > 0)
    {
        remainingTime -= (i*5);
        if(remainingTime >= ( (i+1)*5))
        {
            i++;
        }  
        else
        {
            break; 
        }
        
    }
    if(i >= n) i = n;
    cout << i << endl;
}