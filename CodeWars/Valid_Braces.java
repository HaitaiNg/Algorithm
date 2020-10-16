import java.util.*; 

public class BraceChecker {

  public boolean isValid(String braces) {
    HashMap<Character, Character> characterMappings = new HashMap<Character, Character>(); 
    characterMappings.put(')', '('); 
    characterMappings.put('}', '{');
    characterMappings.put(']', '['); 
    
    Stack<Character> stack = new Stack<Character>(); 
    for(int i = 0; i < braces.length(); i++)
    {
      char c = braces.charAt(i); 
      if(characterMappings.containsKey(c))
      {
        char topElement = stack.empty() ? 'Q' : stack.pop(); 
        if(topElement != characterMappings.get(c)) 
        {
          return false; 
        }
      }
      else
      {
        stack.push(c); 
      }
    }
    return stack.isEmpty(); 
    }
    
}
