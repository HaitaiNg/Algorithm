import java.util.*;

class Solution {
    public int shortestToChar(String S, char C) {
        List<Integer> indexOfCharactersList = new ArrayList<Integer>();
        for(int i = 0; i < S.length(); i++)
        {
            if(S.charAt(i) == C)
            {
                indexOfCharactersList.add(i);
            }
        }
        System.out.println(indexOfCharactersList);
        return 0;
    }

    public static void main(String[] args)
    {
      shortestToChar("loveleetcode", 'e');
    }
}
