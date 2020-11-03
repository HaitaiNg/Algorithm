#include <iostream>
#include <vector>
using namespace std; 

vector<int> merge( vector<int> left, vector<int> right)
{
    vector<int> result; 
    while( left.size() > 0 && right.size() > 0)
    {
        if(left[0] <= right[0])
        {
            result.push_back(left[0]); 
            left.erase(left.begin()); 
            
        }
        else
        {
            result.push_back(right[0]); 
            right.erase(right.begin()); 
        }
    }
    while(left.size() > 0)
    {
        result.push_back(left[0]); 
        left.erase(left.begin()); 
    }
    while(right.size() > 0) 
    {
        result.push_back(right[0]); 
        right.erase(right.begin()); 
    }
    return result; 
}

vector<int> mergeSort( vector<int> array)
{
    if(array.size() <= 1) return array; 
    int midpoint = array.size() / 2; 
    vector<int> left = {array.begin(), array.begin() + midpoint};  
    vector<int> right = {array.begin() + midpoint, array.end()}; 
    left = mergeSort(left); 
    right = mergeSort(right); 
    return merge(left, right); 
}

int main()
{
    vector<int> test {90,523,123,23,700,3003,2,55,0}; 
    test = mergeSort(test); 
    
    for(auto v : test)
    {
        cout << v << " "; 
    }
    cout << endl;
    return 0; 
    
}