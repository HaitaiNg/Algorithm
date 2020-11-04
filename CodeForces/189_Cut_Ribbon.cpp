#include <algorithm>
#include <iostream>
#include <vector> 

using namespace std;

int main()
{
    int n=0, a=0, b=0, c=0; 
    cin >> n >> a >> b >> c; 
    vector<int> x; 
    x.push_back(a);
    x.push_back(b);
    x.push_back(c); 

    sort(x.begin(), x.end()); 
    int cnt = 0; 
    for(int& c: x)
    {
        if(c <= n){
            cnt++;
            n -= c; 
        }
    }
    cout << cnt << endl;
}