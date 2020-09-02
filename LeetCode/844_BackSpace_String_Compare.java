/*
Runtime: 9 ms, faster than 5.39% of Java online submissions for Backspace String Compare.
Memory Usage: 40.2 MB, less than 5.02% of Java online submissions for Backspace String Compare.
*/ 

class Solution {
    
    public String backspaceCompareHelper(String S)
    {
        Stack stackk = new Stack<Character>(); 
        for(int i = 0; i < S.length(); i++)
        {
            char character = S.charAt(i); 
            if(character == '#')
                if(stackk.size() > 0) stackk.pop(); 
                else
                {
                    
                }
            else
                {
                    stackk.add(character); 
                }
        }
        System.out.println(stackk.toString()); 
        return stackk.toString(); 
    }
    
    public boolean backspaceCompare(String S, String T) {
        return backspaceCompareHelper(S).equals( backspaceCompareHelper(T)); 
    }
}
