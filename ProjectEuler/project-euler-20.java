import java.io.*;
import java.util.*;
import java.util.Scanner; 
import java.math.BigInteger; 

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int myInt = scanner.nextInt(); 
        for(int k = 0; k < myInt; k++)
        {
            int c = scanner.nextInt(); 
            BigInteger num = BigInteger.ONE; 
            for(int i = 1; i <= c ; i++){
                num = num.multiply(BigInteger.valueOf(i)); 
            }
            final String bignumber = num.toString(); 
            long result = 0; 
            for(int i = 0; i < bignumber.length(); i++)
            {
                result += Integer.valueOf(String.valueOf(bignumber.charAt(i))); 
            }
            System.out.println(result);
        }
    }
}
