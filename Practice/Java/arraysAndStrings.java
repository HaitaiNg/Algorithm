/*Question (1.1): Implement an algorithm to determine if a string has all unique
characters */

//Ask if the input is an ASCII or Unicode string.
/*Solution One
  Create an array of boolean values where the flag at index i
  indicates whether character i in the alphabet is contained in the string.
  The second time you see this character you can immediately return false
  Time complexity O(n) | Space O(1) */
boolean isUniqueChars(String str)
{
  if(str.length() > 128) return false;
  boolean[] charSet = new boolean[128];
  for(int i = 0; i < str.length(); i++)
    {
    int val = str.charAt(i);
    if(charSet[val])
    {
      return false;
      }
    }
  return true;
}

/*if you cannot use additional data structures
  compare every character to the string to every other character
  two for loops (O(n^2))

  Sort the str. Compare the characters and their neighbors. O(nlog(n)) to sort
  This requires memory to sort */

  //------------------------------------------------------------------------\\

/* Question (1.2): Given two strings, write a method to decide if one is a permutation of the
  other */

// Use an array like a hash table
// map each character to its frequency
// increment frequency while iterating string s, decrement when iterating
// string t
// array should contain all 0s
boolean permutations(String s, String t)
{
  if(s.length() != t.length())
  {
    return false;
  }

  int[] letters = new int[128]; //Assuming ASCII
  for(int i = 0; i < s.length(); i++)
  {
    letters[s.charAt(i)]++;
  }
  for(int j = 0; j < t.length(); j++)
  {
    letters[t.charAt(j)]--;
    if(letters[t.charAt(j)] < 0
    {
      return false;
    }
  }
  return true;
}

//------------------------------------------------------------------------\\
//Quuestion (1.3): write a method to replace all spaces in a string with '%20'.
//Each string has sufficient space to hold all the additional characters
//Input: "Mr John Smith     ", 13
//Output: "Mr%20John%20Smith"

/* Algorithm: scan and count the number of spaces. Triple that count.
 Iterate through the string in reverse order and insert the characters "%20"
 Java strings are immutable.
 */

 void replaceSpaces(char[] str, int trueLength)
 {
   int spaceCount = 0, index, i = 0;
   for(int i = 0; i < trueLength; i++)
   {
     if(str[i] == ' ')
     {
       spaceCount++;
     }
   }

   index = trueLength + spaceCount * 2;
   if(trueLength < str.length) str[trueLength] = '\0'; // end of array
   for(int i = trueLength - 1; i >= 0; i--)
   {
     if(str[i] == ' ')
     {
       str[index - 1] = '0';
       str[index - 2] = '2';
       str[index - 3] = '%';
       index = index - 3;
     }
     else
     {
       str[index - 1] = str[i];
       index--;
     }
   }
}
