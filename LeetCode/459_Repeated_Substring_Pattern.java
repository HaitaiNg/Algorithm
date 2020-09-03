class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int lengthOfString = s.length(); 
        for(int i = lengthOfString / 2; i >= 1; i--)
        {
            int m = lengthOfString / i; 
            String subS = s.substring(0,i); 
            StringBuilder sb = new StringBuilder(); 
            for(int j = 0; j < m; j++)
            {
                sb.append(subS); 
            }
            if(sb.toString().equals(s)) return true; 
        }
        return false; 
    }
}