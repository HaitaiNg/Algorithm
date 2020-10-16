import java.util.List;
import java.util.*; 

class Permutations {

    public static List<String> merge(List<String> list, String c) {
      List<String> res = new ArrayList<String>();
      // Loop through all the string in the list
      for (String s : list) {
          // For each string, insert the last character to all possible positions
          // and add them to the new list
          for (int i = 0; i <= s.length(); ++i) {
              String ps = new StringBuffer(s).insert(i, c).toString();
              res.add(ps);
            }
        }
        return res;
      }    


    
    public static List<String> singlePermutations(String s) {
        List<String> listOfStrings = new ArrayList<String>();
        if(s.length() == 0) return listOfStrings; 
        
        if(s.length() == 1)
        {
          listOfStrings.add(s);
          return listOfStrings; 
        }
        else
        {
          int lastIndex = s.length() - 1;
          String last = s.substring(lastIndex); 
          String rest = s.substring(0, lastIndex); 
          listOfStrings = merge( singlePermutations(rest), last); 
        }
        
        Set<String> x = new HashSet<String>(); 
        for(String entry : listOfStrings)
        {
          x.add(entry); 
        }
        List<String> returnList = new ArrayList<String>(); 
        for(String y: x)
        {
          returnList.add(y); 
        }
        
        
        return returnList;
    }
}
