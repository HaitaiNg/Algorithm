#include <algorithm>
#include <iostream>
#include <map> 
#include <vector> 
using namespace std;

int main()
{
    int s, n, x, y;  
    cin >> s >> n; 
    vector<pair<int,int>> dragons; 
    while(n > 0)
    {
        cin >> x >> y;
        dragons.push_back( make_pair(x, y));    
        n--;     
    }

    std::sort(dragons.begin(), dragons.end());

    for(int i = 0; i < dragons.size(); i++)
    {
        if(dragons[i].first >= s)
        {
            cout << "NO" << endl; 
            return 0;
        }
        else
        {
            s += dragons[i].second;
        }
        
    }
    cout << "YES" << endl;
}