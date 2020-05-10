import java.util.*;

public class CodeWarsPractice {
   
    public boolean check(String sentence){
        if(sentence == null) return false; 
          sentence = sentence.toLowerCase().trim();
          Set<Character> alphabetSet = new HashSet<Character>();
          String alphabetString = "abcdefghijklmnopqrstuvwxyz"; 
          for(char x : sentence.toCharArray())
          {
            String characterRep = String.valueOf(x); 
            System.out.println(alphabetString.contains(characterRep) + "  " + characterRep);
            if(alphabetString.contains(characterRep))
            {
              alphabetSet.add(x); 
            }
          }
          return alphabetSet.size() == 26; 
        }


    public static void main(String[] args)
    {
        String pangram1 = "Cwm fjord bank glyphs vext quiz";
        String pangram2 = "Pack my box with five dozen liquor jugs.";
        String pangram3 = "How quickly daft jumping zebras vex.";
        String pangram4 = "ABCD45EFGH,IJK,LMNOPQR56STUVW3XYZ";
        String pangram5 = "abcdefghijklmopqrstuvwxyz";
        CodeWarsPractice codeWars = new CodeWarsPractice(); 
        System.out.println(codeWars.check(pangram1)); 
        // System.out.println(codeWars.check(pangram2));  
        // System.out.println(codeWars.check(pangram3)); 
        // System.out.println(codeWars.check(pangram4)); 
        // System.out.println(codeWars.check(pangram5)); 
        Map<Integer, List<Integer>> newMap = new HashMap<Integer, List<Integer>>(); 
    
    
    }
}