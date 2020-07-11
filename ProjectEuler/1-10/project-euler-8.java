
Description: Find the greatest K 
consecutive digits in the N digit number.
Completed using Java 8. 
*/ 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void getMax(int n, int k, String num)
    {
        int product = 1; int max = 0;
        for(int i = 0; i < n - k; i++)
        {
            for(int j = 0; j < k; j++)
            {
                char character = num.charAt(i+j); 
                int m = Integer.parseInt(String.valueOf(character)); 
                product = product * m; 
            }
            if(product > max) max = product; 
            product = 1; 
        }
        System.out.println(max); 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            getMax(n, k, num); 
        }
    }
}