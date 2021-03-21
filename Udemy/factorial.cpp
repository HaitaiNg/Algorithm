#include <iostream>

using namespace std;


//< Strong factorial function
//< After the tail recursive function call the frame on the stack
//< is no longer used (no unknown variables) 
int factorial(int N, int result){
    if( N == 1) return result;
    return factorial(N-1, N * result); 
}


int main()
{
    factorial(5,1); 
    return 0; 
}