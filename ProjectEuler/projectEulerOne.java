import java.util.*; 
import java.math.*; 
import java.math.BigInteger; 

public class projectEulerOne{

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

	//< XV  Dynamic Programming (15) hard 
	public static long  LatticePaths()
	{
		long gridSize = 20; 
		long paths = 1; 
		for(long i = 0; i < gridSize; i++){
			paths *= (2 * gridSize) - i; 
			paths /= i + 1; 
		}
		System.out.println(paths); 
		return paths; 
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

	//> XVIII (Dynamic Programming Hard) 
	public static int maximumPathSum()
	{
		
		int tri[][] = null; 
		int m = 0, n = 0;
		for(int i = m - 1; i >= 0; i--){
			for(int j = 0; j <= i; j++)
			{
				if(tri[i+1][j] > tri[i+1][j+1]){
					tri[i][j] += tri[i+1][j]; 
				}else{
					tri[i][j] += tri[i+1][j+1]; 
				}
			}
		}
		return tri[0][0];
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
		// highlyDivisibleTriangularNumber(); //< Solution: 76576500 (12) 
	 	// longestCollatzSequence(); //< Solution: 837799 (Collatz's Conjecture)  (14) 
		// LatticePaths(); //< Solution: 137846528820 (15) 
		// powerDigitSum(); //< Solution: 1366 (16) 
		// maximumPathSum(); //< Solution: 1074 (18) 
		// factorialDigitSum(); //< Solution: 648 (20) 
	} 
}
