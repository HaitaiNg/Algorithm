// Grouping options 
//Given a number n and a number of groups k, find the distinct options to form k 
//where the group of numbers sum up to n


#include <iostream> 
using namespace std; 

int total; 
void findCombinationsUtil(int arr[], int index, 
					int num, int reducedNum, int groups) 
{ 
	// Base condition 
	if (reducedNum < 0) 
		return; 

	// If combination is found, print it 
	if (reducedNum == 0) 
	{ 
        int c = 0; 
		for (int i = 0; i < index; i++) 
            c++; 

        if(c == groups)
        {
            for(int j = 0; j < index; j++)
            {
                cout << arr[j] << " "; 
            }
            cout << endl;
            total++; 
        }
		return; 
	} 

	// Find the previous number stored in arr[] 
	// It helps in maintaining increasing order 
	int prev = (index == 0)? 1 : arr[index-1]; 

	// note loop starts from previous number 
	// i.e. at array location index - 1 
	for (int k = prev; k <= num ; k++) 
	{ 
		// next element of array is k 
		arr[index] = k; 

		// call recursively with reduced number 
		findCombinationsUtil(arr, index + 1, num, 
								reducedNum - k, groups); 
	} 
} 

/* Function to find out all combinations of 
positive numbers that add upto given number. 
It uses findCombinationsUtil() */
int countOptions(int people, int groups) 
{ 
	int arr[people]; 
	findCombinationsUtil(arr, 0, people, people, groups); 
    cout << total << endl;
    return total; 
} 

// Driver code 
int main() 
{ 
    int n, k;
    cin >> n >> k; 
	countOptions(n, k); 
	return 0; 
} 