"""
Description: What is the smallest number that can be divided by 
each of the numbers from  to without any remainder. 
What is the smallest positive number that 
is evenly divisible(divisible with no remainder) 
by all of the numbers from  to? Completed using Java 8 
"""

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int smallestMultiple(int n)
    {
        int smallestMultiple = n; int numberOfDivisions = 0; 
        while(true)
        {
            for(int i = 1; i < n + 1; i++)
            {
                if(smallestMultiple % i == 0)
                {
                    numberOfDivisions++; 
                }
                else
                {
                    numberOfDivisions = 0; 
                    break; 
                }
            }
            if(numberOfDivisions == n)
            {
                return smallestMultiple;
            }
            smallestMultiple++; 
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(smallestMultiple(n)); 
        }
    }
}