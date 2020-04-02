import java.util.*;

public class projectEulerFour{

    // (49) Prime Permutations
    public static int primerPermutations()
    {
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

	public static void main(String[] args) throws Exception{
        // consecutivePrimeSum(); //< Solution: 997651 (50) 
		}
}

