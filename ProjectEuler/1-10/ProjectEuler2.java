"""
Description: Considering the terms in the Fibonacci Sequence whose 
values do not exceed N, find the sum of even valued terms.
Completed using Java 8 

"""

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void fibonacciSequence(long n )
    {
        List<Long> fibonacciSequence = new ArrayList<Long>(); 
        fibonacciSequence.add((long) 1);
        fibonacciSequence.add((long) 2); 
        long sumOfEvenTerms = 2; 
        while(fibonacciSequence.get(1) < n)
        {
            long indexOne = fibonacciSequence.get(1); 
            fibonacciSequence.set(1, fibonacciSequence.get(0) + fibonacciSequence.get(1));
            fibonacciSequence.set(0, indexOne); 
            if(fibonacciSequence.get(1) % 2 == 0 && fibonacciSequence.get(1) < n)
            {
                sumOfEvenTerms += fibonacciSequence.get(1); 
            }
        }
        System.out.println(sumOfEvenTerms); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            fibonacciSequence(n); 
        }
    }
}
