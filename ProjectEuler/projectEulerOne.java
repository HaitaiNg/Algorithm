import java.util.*; 
import java.util.Random; 

/* Description: Project Euler Set [I, X] */ 

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

    // V: Smallest multiple: find number that is divisible by all numbers [1,20]
    public static int smallestMultiple()
    {
        int x = 1; 
        while(true){
            for(int i = 1; i <= 20; i++){
                if(x % i == 0){
                    if(i == 20) return x;  
                }
                else{
                    break;
                }
            }
            x++; 
        }
    }

    // VI: Sum Square Difference 
    public static long sumSquareDifference(){
        long sumOfSquaresOfFirstHundredNumbers = 0; 
        long i = 1; 
        while(i <= 100){
            sumOfSquaresOfFirstHundredNumbers += i * i; 
            i++; 
        }
        long sumOfSquareSum = 0; 
        long j = 1; 
        while(j <= 100){
            sumOfSquareSum += j; 
            j++; 
        }
        sumOfSquareSum = sumOfSquareSum * sumOfSquareSum; 
        return Math.abs(sumOfSquaresOfFirstHundredNumbers - sumOfSquareSum); 
        // The sum of all natural numbers can be expressed as : n(n+1)/2 
        // The sum of squares of the first n natural numbers is : n(n+1)(2n-1)/6 
    }

    //VII: 1001st Prime Number 
    public static long bigPrimeNumber(){
        int nthPrime = 2; 
        int value = 4; 
        Set<Integer> primeSet = new HashSet<Integer>(); 
        primeSet.add(2); 
        primeSet.add(3); 
        int primeFlag = 1; // assume that the number is prime
        Iterator<Integer> it = primeSet.iterator(); 
        while(nthPrime < 10001){
            primeFlag = 1; 
            while(it.hasNext()){
                int aPrimeNumber = it.next(); 
                if(value % aPrimeNumber == 0){
                    primeFlag = 0; 
                    break; 
                }
            }
            if(primeFlag == 1){
                primeSet.add(value); 
                nthPrime++;
            }
            it = primeSet.iterator(); 
            value++;
        }
        List<Integer> primeNumberList = new ArrayList<Integer>(primeSet); 
        Collections.sort(primeNumberList); 
        System.out.println(primeNumberList.get(primeNumberList.size() - 1)); 
        return primeNumberList.get(primeNumberList.size() - 1); 
    }

    // IX Pythagorean Triplet 
    public static int pythagoreanTriplet(){
        int a = 0, b = 0, c = 0; 
        int s = 1000; 
        boolean found = false; 
        for(a = 1; a < s/3; a++){
            for(b = a; b < s/2; b++){
                c = s - a - b; 
                if( a*a + b*b == c*c){
                    found = true;
                    break; 
                }
            }
            if(found) break; 
        }
        System.out.println(a + " " + b + " " + c);
        return a; 
    }

    // X : Summation of Primes 
    public static long summationOfPrimes()
    {
        long sum = 0 ;
        for(int i = 1; i < 2000000; i++){
            if(isPrime(i)) sum += i; 
        }
        System.out.println(sum);
        return sum; 
    }

    public static boolean isPrime(long n){
        if (n < 2) return false; 
        else if( n == 2) return false; 
        for(int i = 2; i < Math.pow(n, 0.5) + 1; i++){
            if (n % i == 0) return false; 
        }
        return true; 
    }

    public static void main(String[] args){
        // multiplesOfThreeAndFive(); //< Solution: 223168 
        // evenFibonacciNumbers(); //< Solution:  4613732 
        // largestPrimeFactorsOfAVeryLargeNumber(); //< Solution: 20 
        // largestPalindromeProduct(); //< Solution: 906609 
        // smallestMultiple(); //< Solution: 232792560 
        // sumSquareDifference() //< Solution: 25164150
        // bigPrimeNumber(); //< Solution: 104743 
        // pythagoreanTriplet(); //< Solution: 200, 375, 425 
        // summationOfPrimes(); //< Solution 142913828920
    }
}
