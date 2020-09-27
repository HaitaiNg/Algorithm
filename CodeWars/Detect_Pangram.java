import java.util.*; 

public class PangramChecker {
  public boolean check(String sentence){
        if(sentence == null) return false; 
          sentence = sentence.toLowerCase().trim();
          Set<Character> alphabetSet = new HashSet<Character>();
          String alphabetString = "abcdefghijklmnopqrstuvwxyz"; 
          for(char x : sentence.toCharArray())
          {
            String characterRep = String.valueOf(x); 
            if(alphabetString.contains(characterRep))
            {
              alphabetSet.add(x); 
            }
          }
          return alphabetSet.size() == 26; 
  }
}