import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static List<Integer> prime(int n, List<Integer> listOfPrimeNumbers)
    {
        int mostRecentValue = listOfPrimeNumbers.get(listOfPrimeNumbers.size() - 1); 
        while(listOfPrimeNumbers.size() - 1 < n)
        {
            mostRecentValue += 2; 
            int y = (int) Math.floor( Math.pow(mostRecentValue, 0.5)); 
            for(int primeNumber: listOfPrimeNumbers)
            {
                if(primeNumber > y)
                {
                    listOfPrimeNumbers.add(primeNumber); 
                    break; 
                }
                if(mostRecentValue % primeNumber == 0)
                {
                    break; 
                }
            }
        }
        return listOfPrimeNumbers; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> listOfPrimeNumbers = new ArrayList<Integer>(); 
        listOfPrimeNumbers.add(2);
        listOfPrimeNumbers.add(3); 
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if(listOfPrimeNumbers.size() < n)
            {
                listOfPrimeNumbers = prime(n, listOfPrimeNumbers); 
            }
            System.out.println(listOfPrimeNumbers.get(n - 1));
        }
    }
}
