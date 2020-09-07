import java.util.Stack;

/* We can use a stack to eliminate matching pair of parentheses.
The number of remaining parentheses left in the stack is the number
of unmatched opening parentheses while the number of times
we were supposed to pop from the stack but could not (because it was empty)
is the number of unmatched closing parentheses)
*/

class Solution{
  public static String solution(String parentheses){
    int numUnmatchedClosingBraces = 0;

    Stack stack = new Stack();
    for(int i = 0; i < parentheses.length(); i++)
    {
      if(curr == '(')
      {
        stack.push(curr);
      }
      else
      {
        if(!stack.isEmpty())
        {
          stack.pop();
        }
        else
        {
          numUnmatchedClosingBraces++;
        }
      }
    }

    int numUnmatchedOpeningBraces = stack.size();

    /* Using a string builder object to insert an opening parentheses to  the front
    and closing parentheses to the end to make the algorithm more efficient. Since strings are
    immutable, we want to avoid unnecessary copying */
    StringBuilder sb = new StringBuilder(parentheses);
    for(int i = 0; i < numUnmatchedOpeningBraces; i++)
    {
      sb.append(")");
    }
    for(int i = 0; i < numUnmatchedClosingBraces; i++)
    {
      sb.insert(0, "(");
    }

    return sb.string();
  }
} 





}
