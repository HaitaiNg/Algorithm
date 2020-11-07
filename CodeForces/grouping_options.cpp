#include <iostream>
#include <vector>
#include <algorithm> 

using namespace std;


int binomicalCoefficient(int n, int k)
{
    int C[n+1][k+1]; 
    int i,j; 
    for(int i = 0; i <= n; i++)
    {
        for(int j = 0; j <= min(i, k); j++)
        {
            if(j == 0 || j == i)
            {
                C[i][j] = 1; 
            }
            else
            {
                cout << C[i-1][j-1] << " " << C[i-1][j] << endl; 
                C[i][j] = C[i-1][j-1] + C[i-1][j]; 
            }
            
        }
    }

    for(int i = 0; i <= n; i++)
    {
        for(int j = 0; j <= min(i,k); j++)
        {
            //cout << C[i][j] << endl; 
        }
       // cout << endl;
    }
    return C[n][k];
}

int countOptions(int people, int groups)
{
    return binomicalCoefficient(people - 1, groups - 1); 
}

int main()
{
    int n,k;
    cin >> n >> k;
    cout << countOptions(n, k) << endl; 
}