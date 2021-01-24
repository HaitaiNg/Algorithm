/*
README: 10.31.20 
This problem was very difficult. I kept expereiencing TLE errors via 
Python so I solved this in Java. I had to look online for some editorials 
as I kept hitting TLE for test cases 4-12. I tried various approaches,
hash maps, memoization, caching. This solution here is a minor variation 
of Pavol Pidanic's solution. I just refactored a few of the variable names, 
and typed it out myself. 

Reference. Pavol Pidanic created a beautiful solution to this problem. 
I should of pre-computed the cache before accepting the test cases / inputs. 
Pre-compute 1x, just access and print out results afterwards. 

Link: http://pidanic.com/en/blog/hackerrank-project-euler-014-longest-collatz-sequence/
*/ 


import java.io.*;
import java.util.*;
import java.util.Scanner; 

public class Solution {

    //private static final int size = (int) Math.pow(10,6); 
    private static final int size = 5_000_000; 
    private static int[] cache = new int[ size + 1]; 
    private static int[] sequence_cache = new int[ size + 1]; 

    public static  void computeCache()
    {
        cache[0] = 1; cache[1] = 1; 
        sequence_cache[0] = 1; sequence_cache[1] = 1; 
        int best = 0; int max = 0; 
        for(int i = 2; i <= size; i++)
        {
            int sequence = 0; 
            long k = i; 
            while(k > 1)
            {
                if(sequence_cache[i] > 0)
                {
                    sequence += cache[i]; 
                    break; 
                }
                sequence++; 
                if(k % 2 == 0){
                    k >>= 1;
                }
                else
                {
                    k = 3*k + 1; 
                }
            }
            cache[i] = sequence; 
            if(sequence >= best)
            {
                best = sequence; 
                max = i; 
            }
            sequence_cache[i] = max; 
        }
    }

    public static void main(String[] args) {
        computeCache(); 
        Scanner scanner = new Scanner(System.in); 
        int n = Integer.parseInt(scanner.nextLine()); 
        for(int i = 0; i < n; i++)
        {
            int j = Integer.parseInt(scanner.nextLine()); 
            System.out.println(sequence_cache[j]); 
        }
        scanner.close(); 
    }
}


/*
//Solution has TLE error 

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int myInt = scanner.nextInt();
        for(int k = 0; k < myInt; k++) 
        {
        long longestSequence = 0, integerWithLargestSequence = 0; 
        for(long i = scanner.nextInt(); i >= 0; i--)
        {
            long sequence = 0; 
            long j = i; 
            while(j > 1){
                if(j % 2 == 0){
                    j = j/2; 
                }else{
                    j = 3*j + 1;
                }
                sequence++; 
            }
            if(sequence > longestSequence){
                longestSequence = sequence; 
                integerWithLargestSequence = i;
            }
        }
        System.out.println(integerWithLargestSequence); 
        }
    }
}
*/ 
