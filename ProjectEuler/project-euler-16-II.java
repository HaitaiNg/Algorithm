import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.util.Scanner; 

public class Solution {
    
    
    public static int sumDigits(BigInteger input){
        int sum = 0; 
        BigInteger[] divideAndRemainder; 
        while(input.compareTo(BigInteger.ZERO) > 0){
            divideAndRemainder = input.divideAndRemainder(BigInteger.TEN); 
            input = divideAndRemainder[0]; 
            sum += divideAndRemainder[1].intValue(); 
        }
        return sum; 
    }

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in); 
       int k = scanner.nextInt();
       for(int i = 0; i < k; i++)
       {
           int c = scanner.nextInt();
            BigInteger two = new BigInteger("2"); 
            System.out.println(sumDigits(two.pow(c)));   
       }
    }
}

