#include <iostream>
#include <algorithm>
#include <vector> 

using namespace std;

int main()
{
    int t = -1, n = 0; 
    cin >> t; 
    while(t > 0)
    {
        cin >> n; 
        vector<int> result; 
        if(n > 9){
            int multiplier = 1; 
            while(n > 0)
            {
                int right = n % 10; 
                if(right != 0){
                    result.push_back( right * multiplier); 
                }
                n /= 10; 
                multiplier *= 10; 
            }
        }
        else
        {   
            result.push_back(n);
        }
        
        cout << result.size() << endl;
        for(int& x : result)
        {
            cout << x << " "; 
        }
        cout << endl;
        t--; 
    }
}