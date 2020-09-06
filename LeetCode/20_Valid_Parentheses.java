class Solution {
    
    static Map<Character, Character> mappings = new HashMap<>(); 
    
    static { 
            mappings.put('(', ')');
            mappings.put('{', '}');
            mappings.put('[', ']'); 
        }
    
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>(); 
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i); 
            if(mappings.containsKey(c))
            {
                stack.push(mappings.get(c)); 
            }
            else if (mappings.containsValue(c))
            {
                if(stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        return stack.isEmpty(); 
    }
}
