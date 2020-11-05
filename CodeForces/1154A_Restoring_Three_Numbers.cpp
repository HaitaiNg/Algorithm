#include <vector>
#include <algorithm> 
#include <iostream>

using namespace std;

int main()
{
    int a=0,b=0,c=0,d=0, max=-1; 
    cin >> a >> b >> c >> d; 
    vector<int> result;
    result.push_back(a);
    result.push_back(b);
    result.push_back(c); 
    result.push_back(d); 
    std:sort(result.begin(), result.end()); 
    max = result[3]; 

    cout << result[3] - result[0] << " " << result[3] - result[2] << " " << result[3] - result[1] << endl;
}