class Solution{
public:
	void reverseString(vector<char>& s){
		int leftPointer = 0;
		int rightPointer = s.size() - 1;
		while(leftPointer < rightPointer){
			int charSwap = s.at(leftPointer);
			s[leftPointer] = s[rightPointer];
			s[rightPointer] = charSwap;
			leftPointer++; 
			rightPointer--;
			}
		}

