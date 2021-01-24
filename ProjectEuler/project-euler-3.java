/*
Description: The prime factors of 13195 are 5,7,13
and 29. What is the largest prime factor of 
a given number N? Completed using Java 8 

This solution is based off of : Oussama Zaki. I liked 
how he used a refined version of Eratosthenes sieve
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long largestPrimeFactorsOfANumber(long n )
    {
        long maxPrime = 1; 
        //Count the number of 2's that divide into it 
        while(n % 2 == 0){
            maxPrime = 2; 
            n >>= 1; 
        }
        // N is now odd, skip even numbers and iterate only for odd integers
        for(int i = 3; i <= Math.sqrt(n); i+= 2) {
            while(n % i == 0){
                maxPrime = i; 
                n = n /i; 
            }
        }
        // Handles the edge case when n is a prime number greater than 2 
        if(n > 2) maxPrime = n; 
        System.out.println(maxPrime);
        return maxPrime; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            largestPrimeFactorsOfANumber(n); 
        }
    }
}