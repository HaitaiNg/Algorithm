#include <iostream>
 
using namespace std;
 
int main()
{
    int n;
    cin >> n;
    int a[n];
 
    for(int i = 0 ; i < n ; i++){
        cin >> a[i];
    }
 
    int high = 1;
    int highest = 1;
 
    for(int j = 1 ; j < n ; j++){
        if (a[j] >= a[j-1]){
            high++;
            if (high > highest) {
                highest = high;
            }
        }else high = 1;
    }
 
    cout << highest;
}
