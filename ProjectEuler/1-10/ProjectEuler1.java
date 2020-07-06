""" 
Description: Find the sum of all multiples 
of 3 or 5 below N. Completed using Java 8. 

Naive solution is to use module operator 
This will result in a timeout for test cases 
where N is very large (10^6) 

Correct solution: Use the arithmetic series & 
Triangle number 
Tn = 1 + 2 + 3 + 4 + 5 .... n 
   = [n(n+1)] / 2 

S3 = sum of all multiples of three 
S3 = 3 + 6 + 9 ... + 3i 
   = 3 ( 1 + 2 + 3 + ....+ i) 
   = [3 (n / 3 )( n / 3 + 1)] / 2 

S5 = sum of all multiples of five 
S5 = 5 + 10 + 15  .... + 5i 
   = 5 ( 1 + 2 + 3 + ..... + i) 
   = [5 * (n / 5)( n / 5 + 1)] / 2 

** You cannot count multiples of 3 & 5 twice.
Subtract common multiples of 3 & 5. To do that 
you subtract the least common multiple of 3 & 5,
which for this example is 15 

S15 = 15 + 30 + 45 ... + 15i 
    = [ 15 * (n / 15)( n /15 + 1)] / 2 

Solution = S3 + S5 - S15 

"""

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long sum(long n, long k)
    {
        return (k * (Math.floorDiv(n, k)) * (Math.floorDiv(n, k) + 1) ) / 2; 
    } 

    public static long multiplesOfThreeAndFive(long n )
    {
        return sum(n, 3) + sum(n, 5) - sum(n, 15); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(multiplesOfThreeAndFive(n - 1)); 
        }
    }
}