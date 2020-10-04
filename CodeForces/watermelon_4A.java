
import java.util.*; 
import java.util.Scanner;

public class Problem4A{ 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); 
        int watermelonSize = scanner.nextInt(); 
        if(watermelonSize % 2 == 0 && watermelonSize > 2)
        {
            System.out.println("Yes"); 
        }
        else
        {
            System.out.println("No");
        }
    }
}