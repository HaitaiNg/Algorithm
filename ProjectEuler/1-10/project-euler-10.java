/*
Description: Summation of primes.
Find the sum of all the primes not greater than a
given N. Completed using Python 3.6.5

Inspired by a solution that was previously submitted by
https://www.hackerrank.com/prateekmishra95. This problem
requires a very time efficient solution which is why
it is recommended to solve for all primes then just search
the corresponding value in a list of all summation of primes. 
*/ 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        int n = 10000;
        int[] listOfValues = new int[n];
        boolean[] isPrime = new boolean[n]; 
        Arrays.fill(listOfValues, 0); 
        Arrays.fill(isPrime, true); 
        isPrime[0] = false;
        isPrime[1] = false; 
        
        int p = 1; 
        while(p < n)
        {
            if(isPrime[p])
            {
                listOfValues[p] = listOfValues[p-1] + p; 
                for(int i = p*p; i < n; i += p)
                {
                    isPrime[i] = false;
                }
            }
            else{
                listOfValues[p] = listOfValues[p-1];
            }
            p++; 
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            n = in.nextInt();
            System.out.println(listOfValues[n]); 
        }
    }
}