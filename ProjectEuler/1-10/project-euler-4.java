/*
Description: Largest palindrome product. Find 
the largest palindrome made from the product 
of two 3-digit numbers which is less than N.
Completed using Java 8. 
*/ 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean isPalindrome(int x){
        //Negative numbers, multiples of 10 (excluding 0) are not palindromes 
        if(x < 0 || (x != 0 && x % 10 == 0)) return false; 
        int remain = 0; 
        while(x > remain){
            int temp = x % 10; 
            remain = remain * 10 + temp; 
            x /= 10; 
        }
        return (x == remain || x == remain / 10); 
    }
    public static int largestPalindromeProduct(int n ){
        int startingIndex = 100; 
        int endingIndex = 999; 
        int palindromicValue = -1; 
        for(int i = startingIndex; i < endingIndex; i++)
        {
            for(int j = startingIndex; j < endingIndex; j++)
            {
                int product = i * j; 

                if(isPalindrome(product) && product < n){
                    if(product > palindromicValue) palindromicValue = product; 
                }
            }
        }
        System.out.println(palindromicValue);
        return palindromicValue; 
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            largestPalindromeProduct(n); 
        }
    }
}