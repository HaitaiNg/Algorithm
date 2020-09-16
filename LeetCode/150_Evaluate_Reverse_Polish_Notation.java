import java.util.Stack; 
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stackOfNumbers = new Stack<Integer>(); 
        for(String s: tokens)
        {
            if(s.equals("+"))
            {
                stackOfNumbers.add( stackOfNumbers.pop() + stackOfNumbers.pop()); 
            }
            else if(s.equals("-"))
            {
                stackOfNumbers.add( -stackOfNumbers.pop() + stackOfNumbers.pop()); 
            }
            else if(s.equals("*"))
            {
                stackOfNumbers.add( stackOfNumbers.pop() * stackOfNumbers.pop()); 
            }
            else if (s.equals("/"))
            {
                int secondDigit = stackOfNumbers.pop();
                int firstDigit = stackOfNumbers.pop(); 
                stackOfNumbers.add(firstDigit / secondDigit); 
            }
            else
            {
                stackOfNumbers.add(Integer.parseInt(s)); 
            }
        }
        return stackOfNumbers.pop(); 
    }
}