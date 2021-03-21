#include <iostream>
using namespace std;

int binarySearch(int nums[], int low, int high, int num){
    if(low > high) return -1; 

    int mid = low + (high - low) / 2; 
    if(nums[mid] == num) return mid;
    if(num > nums[mid]) return binarySearch(nums, mid+1, high, num);
    else return binarySearch(nums, low, mid-1, num); 
}