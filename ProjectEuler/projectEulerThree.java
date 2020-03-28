import java.util.*;

import jdk.internal.agent.resources.agent;

import java.math.*;
import java.io.*; 

public class projectEulerThree{

	//XXI : Amicable Numbers. (Medium) 
	public static long divisorEquation(long target){
		long sumOfDivisorsOfTarget = 0 ;
		for(long i = 1; i <= (target/2); i++){
			if(target % i == 0 && (i * i != target)){
				sumOfDivisorsOfTarget += i; 
			}
		}
		return sumOfDivisorsOfTarget;
	}
	public static int amicableNumbers(){
		long a, b, start = 1, sum = 0 ; 
		HashMap<Long, Long> mappingOfAmicableNumbers = new HashMap<Long, Long>(); 
		while( start <= 100000){
			a = divisorEquation(start);
			b = divisorEquation(a); 
			if(( start == b ) && ( a != b ))
			{
				if(a > b)
				{
					mappingOfAmicableNumbers.put(b, a );
				}
				else
				{
					mappingOfAmicableNumbers.put(a, b); 
				}
			}
			start++; 
		}
		for(long key: mappingOfAmicableNumbers.keySet())
		{
			System.out.println(key + " " + mappingOfAmicableNumbers.get(key)); 
			sum += key + mappingOfAmicableNumbers.get(key); 
		}
		System.out.println("Solution:" + sum ); 
		return 0; 
	}

	//XXII: Names Scores (Easy) 
	public static BigInteger namesScores() throws Exception {
		 File file = new File("/Users/haitai/Downloads/p022_names.txt");
		 FileReader fileReader = new FileReader(file); 
		 BufferedReader br = new BufferedReader(fileReader); 
		 StringBuilder fileContent = new StringBuilder(); 
		 String line; 
		 while((line = br.readLine()) != null) fileContent.append(line); 
		 String[] fileContentList = fileContent.toString().split(",");
		 Arrays.sort(fileContentList);
		 List<Character> alphabetList = new ArrayList<Character>(Arrays.asList('A','B','C','D','E','F','G',
		 'H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')); 
		 HashMap<Character, Integer> alphabetMap = new HashMap<Character, Integer>(); 
		 alphabetMap.put('"', 0); 
		 for(int i = 0; i < alphabetList.size(); i++)
		 {
			 alphabetMap.put( alphabetList.get(i), i + 1); 
		 }
		 BigInteger nameScores = BigInteger.ZERO; 
		 int index = 1; 
		 for(String name: fileContentList){
			long temporarySum = 0; 
			for(char character : name.toCharArray()){
				temporarySum += alphabetMap.get(character); 
			}
			nameScores = nameScores.add(BigInteger.valueOf(temporarySum * index )); 
			index++; 
		}
		System.out.println(nameScores); 
		return nameScores;
	}  

	public static int nonAbundantSums()
	{
		return 0 ; 
	}
	public static int lexicographicPermuations()
	{
		return 0; 
	}

	// XXV (25) 
	public static BigInteger oneThousandthFibonacciNumber()
	{
		List<BigInteger> fibonacciList = new ArrayList<BigInteger>(Arrays.asList( BigInteger.ONE, BigInteger.ONE)); 
		BigInteger index = BigInteger.TWO; 
		BigInteger upperLimit = BigInteger.TEN; 
		upperLimit = upperLimit.pow(999); 
		while(true)
		{
			BigInteger mostRecentNumber = fibonacciList.get(1); 
			if( upperLimit.compareTo(mostRecentNumber) == -1)
			{
				System.out.println(index); 
				return index; 
			}
			else{
				BigInteger newNumber = fibonacciList.get(0).add(fibonacciList.get(1)); 
				fibonacciList.set(0, fibonacciList.get(1)); 
				fibonacciList.set(1, newNumber); 
			}
			index = index.add(BigInteger.ONE); 
		}
	}

	//< XXV1 (26)
	public static int reciprocalCycles(){
		return 0; 
	}

	//< XXVII (27) 
	public static int quadraticPrimes(){
		return 0;
	}

	//< XXVIII (28) 
	public static int numberSpiralDiagonals()
	{
		return 0; 
	}

	//<XXXIV (29) 
	public static int distinctPowers()
	{
		return 0; 
	}

	//< XXX 
	public static int digitFifthPowers()
	{
		int result = 0; 
		for(int i = 2; i < 355000; i++){
			int sumOfPowers = 0; 
			int number = i; 
			while(number > 0){
				int d = number % 10; 
				number = number / 10; 
				int temp = d; 
				for(int j = 1; j < 5; j++)
				{
					temp *= d; 
				}
				sumOfPowers += temp; 
			}
			if(sumOfPowers == i)
			{
				result += i; 
			}

		}
		System.out.println(result);
		return result; 
	}

	public static void main(String[] args) throws Exception{
		//  amicableNumbers(); //< Solution: 852810
		//  namesScores(); //< Solution: 871198282
		// oneThousandthFibonacciNumber(); //< Problem 25: Solution: 4782 
		digitFifthPowers();
		}

}
