import java.util.*;
import java.lang.*; 
import java.math.*;
public class projectEulerFour{
    
    // XL (40) Champernownes Constant  
    public static int champernownesConstant()
    {
        StringBuilder sb = new StringBuilder(); 
        for(int i = 1; i < 10000000; i++)
        {
            sb.append(i); }
            int prod = 1; 
            for(int i = 0; i <= 6; i++)
            {
                prod *= sb.charAt( (int ) Math.pow(10, i) - 1)- '0';
                 
            }
            System.out.println(prod);
        return prod; 
    }

    // XLI (41) Pandigital Prime
    public static int pandigitalPrime()
    {
        int target = 0; 
        for(target = 987654321; target > 0; target--)
        {
            if(isPandigital(target))
            {
                if(isPrime(target))
                {
                    return target; 
                }
            }
        }
        return target; 
    } 


    public static Set<Integer> createNumberSet(int x)
    {
        Set<Integer> numberSet = new HashSet<Integer>(); 
        int numberOfDigits = 0;
        while(x > 0){
            numberOfDigits++; 
            x /= 10; 
        }
        for(int i = 1; i <= numberOfDigits; i++)
        {
            numberSet.add(i); 
        }
        return numberSet;
    }

    public static boolean isPandigital(int i)
    {
        Set<Integer> numberSet = createNumberSet(i);  
        while(i > 0)
        {
            int digit = i % 10; 
            if(numberSet.contains(digit)) numberSet.remove(digit); 
            else{
                return false; 
            }
            i /= 10; 
        }
        if(!numberSet.isEmpty()) return false;
        return true; 
    }
    
    static boolean isPrime(int n) 
    { 
        // Corner cases 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
    } 

    // XLIII Sub-string Divisibility
    public static int substringDivisibility()
    {

     /*
    # time module for calculating execution time
    import time
    # permutations method
    from itertools import permutations
    # time at the start of program execution
    start = time.time()

    # permutations of 0-9 pandigital
    p = permutations('0123456789')

    # variable to store the value of sum
    solution = 0

    # for loop to loop through permutations
    for i in p:
        if (int(''.join(i[7:10])) % 17 == 0 and
            int(''.join(i[6:9])) % 13 == 0 and
            int(''.join(i[5:8])) % 11 == 0 and
            int(''.join(i[4:7])) % 7 == 0 and
            int(''.join(i[3:6])) % 5 == 0 and
            int(''.join(i[2:5])) % 3 == 0 and
            int(''.join(i[1:4])) % 2 == 0):
            solution += int(''.join(i))

    # printing the solution
    print solution
    # time at the end of program execution
    end = time.time()
    # total time taken
    print end - start
    */
    
    return 0; 
    }

    // (50) (Very Hard)
    // Had to get help from this source:
    // https://radiusofcircle.blogspot.com/2016/06/problem-50-project-euler-solution-with-python.html
    public static List<Integer> findNextPrime()
    {
        long upperLimit = 1000000;
        List<Integer> listOfPrimes = new ArrayList<Integer>(); 
        listOfPrimes.add(2); listOfPrimes.add(3); listOfPrimes.add(5); 
        listOfPrimes.add(7); listOfPrimes.add(11); listOfPrimes.add(13); 
        int primeFlag = 0; 
        for(int i = 14; i <= upperLimit; i++)
        {
            primeFlag = 0; 
            for(int prime: listOfPrimes){
                if(i % prime == 0){
                    primeFlag = 1; 
                    break; 
                }
            }
            if(primeFlag == 0){
                listOfPrimes.add(i);
            }
        }
        return listOfPrimes; 
        
    }
 
    public static int sumSplice(List<Integer> listOfPrimes, int startIndex, int endIndex)
    {
        int returnSum = 0; 
        for(int i = startIndex; i < endIndex; i++){
            returnSum += listOfPrimes.get(i); 
        }
        return returnSum; 
    }
    
    public static int consecutivePrimeSum()
    {
        // 1.) Create a large array of prime numbers up to 1 million 
        // 2.) Do list splicing to determine the sum that is less than a million 
        // 3.) Return result 
        // Concepts: Miller–Rabin primality test
        // Sieve of Eratosthenes
        List<Integer> listOfPrimes = findNextPrime(); 
        // length, consecutive prime sum, maximum value 
        int length = 0, largest = 0, lastj = listOfPrimes.size(); 
        for(int i = 0; i < listOfPrimes.size(); i++)
        {
            for(int j = i + length; j < lastj; j++){
                int solution = sumSplice(listOfPrimes, i, j); 
                if(solution < 1000000){
                    if(listOfPrimes.contains(solution)){
                        length = j - i; 
                        largest = solution; 
                    }
                }
                else{
                    lastj = j + 1; 
                    break; 
                }
            }
        }
        System.out.println(largest); 
        return 0 ;
    }

    public static BigInteger selfPowers()
    {
        BigInteger modulus = BigInteger.TEN.pow(10);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++){
            sum = sum.add(BigInteger.valueOf(i).modPow(BigInteger.valueOf(i), modulus));
        }
        System.out.println(sum.mod(modulus));
        return sum.mod(modulus); 
        
    }

	public static void main(String[] args) throws Exception{
        // champernownesConstant(); //< Solution: 210 (40)
        // pandigitalPrime(); //< Solution: 7652413 (41)
        // substringDivisibility(); //< Solution: 16695334890 (43);
        // selfPowers(); //< Solution: 9110846700 (48)
        // consecutivePrimeSum(); //< Solution: 997651 (50) 
		}
}

