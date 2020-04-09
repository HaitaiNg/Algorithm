import java.util.*;
import java.math.*;
import java.io.*; 

public class projectEulerTwo{

	//XXI : Amicable Numbers. (Medium) (21)
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

	//XXII: Names Scores (Easy)  (22)
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
	
	//XXIII: Non-abundant sums (hard) (23)
	public static boolean isAbundantNumber(int value){
		var sqrt = (int) Math.sqrt(value); 
		var list = new HashSet<Integer>(); 
		var sum = 0; 
		list.add(1); 
		for(var v = 2; v <= sqrt; v++ )
		{
			if(value % v == 0){
				list.add(v);
				list.add(value / v); 
			}
		}
		for(var d: list){
			sum += d; 
		}
		return sum > value; 
	}
	public static List<Integer> aList(int limit){
		var list = new ArrayList<Integer>(); 
		for(var v = 12; v <= limit; v++)
		{
			if(isAbundantNumber(v)){
				list.add(v); 
			}
		}
		return list; 
	}
	public static int nonAbundantSums()
	{
		return 0 ; 
	}

	// XXIV Lexicographic Permutations (24)
	public static int lexicographicPermuations()
	{
		return 0; 
	}

	// XXV 1000-digit Fibonacci Number (25) 
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

	//< XXV1 Reciprocal Cycles (26) : Nayuki Minase 
	public static int reciprocalCycles(){
		int sequenceLength = 0;
		for(int i = 1000; i > 1; i--)
		{
			if(sequenceLength >= i) break; 
			int[] foundRemainders = new int[i]; 
			int value = 1; 
			int position = 0 ; 
			while(foundRemainders[value] == 0 && value != 0)
			{
				foundRemainders[value] = position; 
				value *= 10;
				value %= i; 
				position++; 
			}
			if(position - foundRemainders[value] > sequenceLength){
				sequenceLength = position - foundRemainders[value]; 
			}
		}
		System.out.println(sequenceLength);
		return sequenceLength;
	}



	//< XXVII Quadratic Primes(27) 
	public static int quadraticPrimes(){
		return 0;
	}

	//< XXVIII Number Spiral diagonals (28) 
	public static int numberSpiralDiagonals()
	{
		return 0; 
	}

	//<XXXIV (29) 
	public static int distinctPowers()
	{
		double temporaryPower = 0; 
		ArrayList<Double> distinctTerms = new ArrayList<Double>(); 
		for(int i = 2; i <= 100; i++){
			for(int j = 2; j <= 100; j++)
			{
				temporaryPower = Math.pow(i, j); 
				if(distinctTerms.contains(temporaryPower) == false) distinctTerms.add(temporaryPower); 
			}
		}
		return distinctTerms.size(); 
	}

	//< XXX (30) 
	public static int digitFifthPowers()
	{
		int sum = 0; 
		for (int i = 2; i < 1000000; i++){
			if( i == fifthPowerDigitSum(i)) sum += i; 
		}
		return sum;
	}

	public static int fifthPowerDigitSum(int x)
	{
		int sum = 0 ; 
		while( x != 0){
			int y = x % 10; 
			sum += y * y * y * y; 
			x /= 10;
		}
		return sum; 
	}

	public static void main(String[] args) throws Exception{
		//  amicableNumbers(); //< Solution: 852810 (21)
		//  namesScores(); //< Solution: 871198282 (22)
		// oneThousandthFibonacciNumber(); //< Solution: 4782 (25)  
		reciprocalCycles();
		// distinctPowers(); //< Soluition: 9183 (29)
		//digitFifthPowers(); //< Solution : 19316 (30)
		}

}
