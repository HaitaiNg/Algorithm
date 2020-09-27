import java.util.*; 

public class Kata {
  public static String highAndLow(String numbers) {
    Scanner scanner = new Scanner(numbers); 
    List<Integer> listOfNumbers = new ArrayList<Integer>(); 
    while(scanner.hasNextInt())
    {
      listOfNumbers.add(scanner.nextInt()); 
    }
    Collections.sort(listOfNumbers); 
    return String.valueOf(listOfNumbers.get(listOfNumbers.size() - 1)) + " " + String.valueOf(listOfNumbers.get(0)); 
  }
}