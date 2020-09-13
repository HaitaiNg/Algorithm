/*
  String rotation: assume you have a method isSubstring
  which checks if one word is a substring of another.
  Given two strings S1, and S2, write code to check if s2 is a rotation
  of S1 using only one call to isSubstring

  do isSubstring(s1s1, s2)

  if s2 is a rotation of s1, then we have to ask what the rotation
  point is. If you rotate waterbottle after wat you get
  erbottlewat

  In a rotation we cut two parts x and y, and rearrange them
  s1 = xy = waterbottle
  x = wat
  y = erbottle
  s2 = yx = erbottlwat

  check if there is a split s1 into x and y such that
  xy = s1, and yx = s2
  s2 will always be a substring of s1s1

  runs in O(A + B) time where (on strings of length A and B)
  O(n) 
 */


 boolean isRotation(String s1, String s2)
 {
   int len = s1.length();
   // check that s1 and s2 are equal length and not empty
   if(len == s2.length() && len > 0)
   {
     // concatenate s1 and s2 within new buffer
     String s1s1 = s1 + s1;
     return isSubstring(s1s1, s2);
   }
   return false;
 }
