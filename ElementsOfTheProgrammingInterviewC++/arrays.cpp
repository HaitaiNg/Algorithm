/* Problem: Given a list of integers, you have to reorder the entries 
so that the even entries appear first. Do this without using additional
allocated space. Use two pointers */ 

void EvenOdd(vector<int>* a_ptr)
{
	vector<int>& a = a_ptr; 
	int next_even = 0, next_odd = a.size() - 1; 
	while(next_even < next_odd){
		if(a[next_even] % 2 == 0) ++next_even; 
		else swap(a[next_even], a[next_odd--]); 
	}
}


/*	C++ syntax 
array<int, 3> A = {1,2,3}; 
vector<innt> A = {1,2,3}; 
vector<int> subarray_A( A.begin() + 1, A.begin() + j); 

2D-array 
array<array<int,2>, 3> A = { {1,2}, {2,3}, {4,5}}; 

Important methods: 
binary_search( A.begin(), A.end(), 42); 
lower_bound( A.begin(), A.end(), 42); 
upper_bound( A.begin(), A.end(), 42); 
fill( A.begin(), A.end(), 42); 
swap(x,y); 
min_element( A.begin(), A.end()); 
max_element( A.begin(), A.end()); 
reverse( A.begin(), A.end()); 
rotate( A.begin(), A.begin() + shift, A.end()); 
sort( A.begin(), A.end()); 




*/ 