import java.util.*;

public class projectEulerFour{

    // (50) 

    public static List<Integer> findNextPrime(List<Integer> listOfPrimes)
    {
        int mostRecentPrime = listOfPrimes.get(listOfPrimes.size() - 1) + 1;
        int primeFlag = 0; 

        while(true)
        {
            for(int primeNumber: listOfPrimes)
            {
                if(mostRecentPrime % primeNumber == 0){
                    primeFlag = -1;  //< this number is not prime 
                }
            }
            if(primeFlag == 0){
                listOfPrimes.add(mostRecentPrime); 
                return listOfPrimes; 
            }
            mostRecentPrime++; 
            primeFlag = 0; 
        }
    }

    public static boolean isPrime(List<Integer> listOfPrimes, int target)
    {
        int consecutiveCondition = 0; 
        for(int primeNumber: listOfPrimes){
            consecutiveCondition += primeNumber; 
            if(target % primeNumber == 0) return false; 
        }

        // We know the number is prime. Check if the sum of the consecutive
        //primes add up to the target 
        return consecutiveCondition == target; 
    }

    public static int consecutivePrimeSum()
    {
        List<Integer> listOfPrimes = new ArrayList<Integer>(); 
        listOfPrimes.add(2); listOfPrimes.add(3); listOfPrimes.add(5); 
        listOfPrimes.add(7); listOfPrimes.add(11); listOfPrimes.add(13); 
        int currentSum = 0; 
        while(true)
        {
            currentSum = 0;
            for(int primeNumber: listOfPrimes)
            {
                currentSum += primeNumber; 
            }
            if(isPrime(listOfPrimes, currentSum) && currentSum > 100 && currentSum < 1000){

                int target = 0; 
                for(int prime: listOfPrimes)
                {
                    target += prime;
                }
                return currentSum; 
            }
            else{
                listOfPrimes = findNextPrime(listOfPrimes); 
            }

        }
    }



	public static void main(String[] args) throws Exception{
        consecutivePrimeSum();
		}
}

