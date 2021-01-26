import java.io.*;
import java.util.*;
import java.math.*; 

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int t = in.nextInt(); 
        BigInteger modulus = BigInteger.TEN.pow(10);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= t; i++){
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), modulus));
        }
        System.out.println(sum.mod(modulus));
    }
}