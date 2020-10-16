
import java.util.*; 

public class way_too_many_words {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); 
        int numberOfWords = Integer.parseInt(scanner.next());
        while(numberOfWords > 0)
        {
            String currentWord = scanner.next(); 
            if(currentWord.length() <= 10) System.out.println(currentWord); 
            else{
                int count = 0; 
                for(int i = 1; i < currentWord.length() - 1; i++)
                {
                    count++; 
                }
                System.out.println(currentWord.charAt(0) + String.valueOf(count) + currentWord.charAt(currentWord.length() - 1)); 
            }
            numberOfWords--; 
        }
        scanner.close(); 
    }
    
}
