import java.util.*; 

class Solution {
  public static String camelCase(String input) {
    Set<Character> upperCaseCharacters = new HashSet<Character>();
    String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for(char character: uppercase.toCharArray())
    {
      upperCaseCharacters.add(character); 
    }
    String returnString = ""; 
    for(char x: input.toCharArray())
    {
      if(upperCaseCharacters.contains(x))
      {
        returnString += " "; 
      }
      
      returnString += x; 
    }
    
    
    
    return returnString;
  }
}
