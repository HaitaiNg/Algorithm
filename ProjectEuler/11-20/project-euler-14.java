
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
