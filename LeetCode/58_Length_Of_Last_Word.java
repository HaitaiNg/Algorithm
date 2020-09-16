class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() <= 0) return 0; 
        s = s.trim(); 
        int rightPointer = s.length() - 1; 
        int count = 0; 
        while(rightPointer >= 0)
        {
            if(s.charAt(rightPointer) == ' ')
            {
                return count; 
            }
            count++; 
            rightPointer--; 
        }
        return count; 
    }
}