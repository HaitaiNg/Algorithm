import java.util.*; 

public class Kata
{
  public static long nextSmaller(long n)
  {
      long num = n; 
        String number = Long.toString(num);
        String[] digitArray = number.split("");

        ArrayList<String> seen = new ArrayList<String>();
        seen.add(digitArray[digitArray.length-1]);
            
        for(int x = digitArray.length - 2; x >= 0 ; x--){
            seen.add(digitArray[x]);
            Collections.sort(seen);
            Collections.reverse(seen);
        
            // smaller number possible if larger digit has lower array index
            if(Integer.parseInt(digitArray[x]) > Long.parseLong(digitArray[x+1])){
                LinkedHashSet<String> s = new LinkedHashSet <> (seen);
                ArrayList<String> uniqueSeen = new ArrayList <> (s);
                
                // switch digits & assemble
                String highestBelow = uniqueSeen.get(uniqueSeen.indexOf(digitArray[x])+1);
                seen.remove(highestBelow);
                String notSeen = String.join("",Arrays.copyOfRange(digitArray,0,x));
                String smallerNum = notSeen + highestBelow + String.join("",seen);
                
                if(smallerNum.charAt(0) == '0'){ // leading zeros not allowed
                    return -1;
                }else{
                    return Long.parseLong(smallerNum);
                }
            }
        }
        
        return -1; // no smaller number
  }
}
