
// Two pointers. One left hand side pointer points to a character on the left side
// Another pointer points to another character on the right side
// continue checking these characters are the same, and iterate down to the middle
// if characters match, return true

import java.util.*; 

class Program {
  public static boolean isPalindrome(String str) {
		int j = str.length() - 1; 
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == str.charAt(j))
			{
				j--; 
			}
			else
			{
				return false; 
			}
		}
		return true; 
  }
}


