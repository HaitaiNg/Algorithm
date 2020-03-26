import java.util.*; 
import java.math.*; 
import java.math.BigInteger; 

public class projectEulerTwo{

	//< XII 
	/* returns the nth triangle number; that is, the sum of all the natural numbers less than, or equal to, n */
	public static int triangleNumber(int n) {
			int sum = 0;
			for (int i = 0; i <= n; i++)
				sum += i;
			return sum;
		}
	public static int highlyDivisibleTriangularNumber()
	{
		int j = 0, n = 0, numberOfDivisors = 0; 
		while(numberOfDivisors <= 500){
			numberOfDivisors = 0; 
			j++; 
			n = triangleNumber(j); 
			//count the number of divisors from 1 to sqrt(n) 
			for (int i = 1; i <= Math.sqrt(n); i++){
				if (n % i == 0)
				numberOfDivisors++;
			}
		
		// 1 to the square root of the number holds exactly half of the divisors
		// so multiply it by 2 to include the other corresponding half
		numberOfDivisors *= 2;
		}
		System.out.println(n);
		return n; 
	}

	//< XIV 
	public static long longestCollatzSequence()
	{
		long longestSequence = 0, integerWithLargestSequence = 0; 
		for(long i = 1000000; i >= 0; i--)
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
		System.out.println("Longest Sequence: " + longestSequence); 
		System.out.println("Number With Largest Sequence: " + integerWithLargestSequence); 
		return longestSequence; 
	}

	//< XV  (Similar to Amazon question) ( Look this Up and watch Tutorials on how to solve )
	public static int LatticePaths()
	{
		//How many such routes are there in a 20x20 grid 
		return 0; 
	}

	//< XV1 
	public static int powerDigitSum()
	{
		BigInteger two = new BigInteger("2"); 
		BigInteger target = two.pow(1000); 
		System.out.println(target + " " + sumDigits(target)); 
		return sumDigits(target); 
		
	}

	public static int sumDigits(BigInteger input){
		int sum = 0; 
		BigInteger[] divideAndRemainder; 
		while(input.compareTo(BigInteger.ZERO) > 0){
			divideAndRemainder = input.divideAndRemainder(BigInteger.TEN); 
			input = divideAndRemainder[0]; 
			sum += divideAndRemainder[1].intValue(); 
		}
		return sum; 
	}

	//> XVIII 
	public static int maximumPathSum()
	{
		return 0; 
	}

	//> XX 
	public static long factorialDigitSum()
	{
		BigInteger num = BigInteger.ONE; 
		for(int i = 1; i <= 100; i++){
			num = num.multiply(BigInteger.valueOf(i)); 
		}
		final String bignumber = num.toString(); 
		long result = 0; 
		for(int i = 0; i < bignumber.length(); i++)
		{
			result += Integer.valueOf(String.valueOf(bignumber.charAt(i))); 
		}
		System.out.println(result); 
		return result; 
	}
	public static void main(String[] args){
		// highlyDivisibleTriangularNumber(); //< Solution: 76576500
		// longestCollatzSequence(); //< Solution: 837799 (Collatz's Conjecture) 
		// LatticePaths(); 
		// powerDigitSum(); //< Solution: 1366 
		// maximumPathSum();
		// factorialDigitSum(); //< Solution: 648 
	} 
}
