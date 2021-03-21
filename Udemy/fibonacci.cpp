#include <iostream> 

using namespace std;

//< head recursion (stack heavy) : requires backtracking 
int fibonacci(int n){
    if( n <= 1) return;
    return fibonacci(n-1) + fibonacci(n-2); 
}

//< tail recursion (better version compared to head)
int fibonacciTail(int n, int a, int b)
{
    if(n == 0) return a;
    if(n == 1) return b; 
    return fibonacciTail(n-1, b, a+b); 
}

int main()
{
    fibonacci(10);
    fibonacciTail(0,1,1);
    return 0; 
}