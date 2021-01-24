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

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        boolean isPrime[] = new boolean[10000000+1];
        for(int i=2;i<=10000000;i++){
            isPrime[i]=true;
        }
        for(int j=2;j*j<=10000000;j++){
            if(isPrime[j]){
                for(int k=j*2;k<=10000000;k+=j){
                    isPrime[k]=false;
                }
            }
        }
        long listOfValues[] = new long[10000000+1];
        long sum2=0;
        for(int f=2;f<=10000000;f++){
            if(isPrime[f]){
                sum2+=f;
            }
            listOfValues[f]=sum2;
        }
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(listOfValues[n]);
        }
    }
}