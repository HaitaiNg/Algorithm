//< https://www.techiedelight.com/check-given-array-represents-min-heap-not/
#include <iostream>
using namespace std;

bool checkMinHeap(int A[], int i, int n){
    if(2*i + 2 > n) return true; 
    bool left = (A[i] <= A[2*i+1]) && checkMinHeap(A, 2*i+1, n); 
    bool right = (2*i + 2 == n) || (A[i] <= A[2*i+2]) && checkMinHeap(A, 2+i+2, n); 
    return left && right; 
}