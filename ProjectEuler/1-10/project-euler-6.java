/*
Description: Find the absolute difference between the sum of the squares of the
first natural numbers and the square of the sum. Completed using Java 8 
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long sumSquareDifference(long n) 
    {
        long squareOfSumOfNaturalNumbers = 0, sumOfSquares = 0; 
        for(long i = 1; i < n + 1; i++)
        {
            squareOfSumOfNaturalNumbers += i; 
            sumOfSquares += Math.pow(i, 2); 
        }
        squareOfSumOfNaturalNumbers = 
           (long) Math.pow(squareOfSumOfNaturalNumbers, 2); 
        return Math.abs(squareOfSumOfNaturalNumbers - sumOfSquares); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println((long) sumSquareDifference(n)); 
        }
    }
}