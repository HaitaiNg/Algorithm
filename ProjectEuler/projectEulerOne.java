import java.util.*; 
import java.util.Random; 
public class projectEulerOne{

    //I: Sum up all values that divide by 3 & 5 : [1,1000]
    public static int multiplesOfThreeAndFive(){
        int target = 1000; 
        int returnValue = 0;
        for(int i = 3; i < 1000; i++){
            if(i % 3 == 0 || i % 5 == 0) returnValue = returnValue + i; 
        }
        System.out.println(returnValue); 
        return returnValue; 
    }
    //II: Fibonacci Numbers: sum up all even-valued terms 
    public static int fibonacciNumbers(int n ){
        if(n <= 1) return n; 
        return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2); 
    }
    public static int evenFibonacciNumbers(){
        int sumOfNumbers = 0; 
        int i = 0; 
        while(true){
            if(sumOfNumbers >= 4000000) break; 
            int fibonacciNumbers = fibonacciNumbers(i); 
            if(fibonacciNumbers % 2 == 0){
                sumOfNumbers += fibonacciNumbers; 
            }
            i++; 
        }
        System.out.println(sumOfNumbers);
        return sumOfNumbers;
    }

    //III: Largest prime factors of a very large number (review) 
    public static long largestPrimeFactorsOfAVeryLargeNumber()
    {
        long n = 13195;
        long maxPrime = 1; 
        //Count the number of 2's that divide into it 
        while(n % 2 == 0){
            maxPrime = 2; 
            n >>= 1; 
        }
        // N must be odd at this point, thus skip the even numbers and iterate only for odd integers
        for(int i = 3; i <= Math.sqrt(n); i+= 2) {
            while(n % i == 0){
                maxPrime = i; 
                n = n /i; 
            }
        }
        // Handles the case when n is a prime number greater than 2 
        if(n > 2) maxPrime = n; 
        System.out.println(maxPrime);
        return maxPrime; 
    }

    //IV: Largest 3 digit palindromic number 
    public static boolean isPalindrome(int x){
        //Negative numbers, multiples of 10 (excluding 0) are not palindromes 
        if(x < 0 || (x != 0 && x % 10 == 0)) return false; 
        int remain = 0; 
        while(x > remain){
            int temp = x % 10; 
            remain = remain * 10 + temp; 
            x /= 10; 
        }// Check even palindrome 
        // Check odd palindrome 
        return (x == remain || x == remain / 10); 
    }
    public static int largestPalindromeProduct(){
        int startingIndex = 100; 
        int endingIndex = 999; 
        int palindromicValue = -1; 
        for(int i = startingIndex; i < endingIndex; i++)
        {
            for(int j = startingIndex; j < endingIndex; j++)
            {
                int product = i * j; 
                if(isPalindrome(product)){
                    if(product > palindromicValue) palindromicValue = product; 
                }
            }
        }
        System.out.println(palindromicValue);
        return palindromicValue; 
    }


    public static void main(String[] args){
        // multiplesOfThreeAndFive();
        //evenFibonacciNumbers();
        //largestPrimeFactorsOfAVeryLargeNumber();
        largestPalindromeProduct();
    }
}
