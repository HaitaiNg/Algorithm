/* 
Description: Pythagorean triple is a set of
three natural numbers a < b < c for which
a^2 + b^2 = c^2. Given N check if there 
exists any pythagorean triplet for which a+b+c = N 
If no pythagorean triplet exists, return -1
Completed using Java 8
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static int pythagoreanTriple(int n)
    {
        int product = -1; 
        for(int a = 3; a < (int) (n/3 + 1); a++)
        {
            int b = (int) ((Math.pow(n,2) - (2*a*n) ) / (2*n - 2*a)); 
            int c = n - b -a; 
            if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2))
            {
                if(a*b*c > product) product = a*b*c;
            }
        }
        return product; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(pythagoreanTriple(n)); 
        }
    }
}