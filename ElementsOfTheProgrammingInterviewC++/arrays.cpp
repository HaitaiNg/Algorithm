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
