"""
Description: 215 = 32768 and the sum of
its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 
21000? Completed using Java 8
"""

import java.io.*;
import java.util.*;
import java.lang.Math.*; 
import java.math.BigInteger; 

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt(); 
        for(int a0 = 0; a0 < t; a0++)
        {
            int n = in.nextInt();
            BigInteger bigInteger = new BigInteger("2"); 
            bigInteger = bigInteger.pow(n);  
            String bigIntegerString = bigInteger.toString(); 
            char c[] = bigIntegerString.toCharArray(); 
            int sum = 0; 
            for(char cc: c)
            {
                sum += (((int)cc)-48); 
            }
            System.out.println(sum); 
        }
    }
}
