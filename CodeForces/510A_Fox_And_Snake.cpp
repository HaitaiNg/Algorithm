#include <iostream>
#include <vector> 

using namespace std;


int main()
{
    int h = 0, w = 0; 
    cin >> h >> w; 

    string body = "", left = "", right = "";
    for(int j = 0; j < w; j++)
    {
        body += "#";
        if(j == 0){
            left = "#";
        }
        
        if(j > 0)
        {
            left += "."; 
        }

        if(j < w -1)
        {
            right += ".";
        }
        else
        {
            right += "#"; 
        }
    }

    bool tail = true;
    for(int i = 1; i < (h + 1); i++)
    {
        if(i % 2 == 0)
        {
            if(tail){
                cout << right << endl; 
                tail = false; 
            }
            else
            {
                cout << left << endl;
                tail = true; 
            }
        }
        else
        {
            cout << body << endl;
        }
        
    }
}