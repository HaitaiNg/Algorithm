import java.util.*; 
import java.math.*; 
import java.math.BigInteger; 

public class projectEulerThree{

        ///< XXXI Coin Sums (31) : Dynamioc Progrmaming 
        public int coinSums()
        {
                int target = 200; 
                int[] coinSizes = {1,2,5,10,20,50,100,200}; 
                int[] ways = new int[target+1]; 
                ways[0] = 1; 
                for(int i = 0; i < coinSizes.length; i++)
                {
                        for(int j = coinSizes[i]; j <= target; j++)
                        {
                                ways[j] += ways[j - coinSizes[i]]; 
                        }
                }
                return ways[200];
        }

        //< XXXII Pandigital Products (32) 
        public int pandigitalProducts()
        {
                Set<Integer> listOfPandigitalSums = new HashSet<Integer>(); 
                for(int i = 1; i < 100000; i++)
                {
                        boolean addCondition = Boolean.TRUE; 
                        for(int j = 1; j < 10000; j++)
                        {
                                int product = j * i; 
                                int referenceI = i; 
                                int referenceJ = j;
                                if(pandigitalHelper(referenceI, referenceJ, product))
                                {
                                        if(!listOfPandigitalSums.contains(product)) listOfPandigitalSums.add(product); 
                                }
                                
                        }
                }
                int sumOfPandigitalSums = 0; 
                for(int pandigitalProduct : listOfPandigitalSums)
                {
                        sumOfPandigitalSums += pandigitalProduct; 
                }
                return 0; 
        }
        public boolean pandigitalHelper( int i, int j, int product)
        {
                String iString = String.valueOf(i).trim(); 
                String jString = String.valueOf(j).trim(); 
                String productString = String.valueOf(product).trim();
                String compute = iString + jString + product;
                if(compute.length() > 9) return false; 

                for(int x = 1; x < 10; x++)
                {
                        if(!compute.contains( String.valueOf(x))) return false;
                }
                return true ; 
        }

        //< XXXIV Digit Factorial (34) 
        public int digitFactorials()
        {
                int sumOfUniqueNumbers = 0; 
                int[] factorials = new int[10]; 
                int sum = 0; 
                for(int i = 0; i < 10; i++)
                {
                        factorials[i] = compuateFactorial(i);
                }

                for(int i = 10; i < 2540161; i++)
                {
                        sum = 0; 
                        int j = i; 
                        while( j > 0)
                        {
                                int digit = j % 10; 
                                sum += factorials[digit]; 
                                j /= 10; 
                        }
                        if(sum == i){
                                sumOfUniqueNumbers++; 
                        }
                }
        
                return sum;
        }
        public int compuateFactorial(int n )
        {
                int returnValue = 1; 
                for(int i = n; i >= 1; i--)
                {
                        returnValue *= n; 
                        n--; 
                }
                return returnValue; 
        }

        /// XXXV Circular Primes (35) :: Incomplete 
        public int circularPrimes()
        {
                int numberOfCircularPrimes = 0; 
                for(int i = 0 ; i < 1000000; i++)
                {
                        if(checkCircular(i)){
                                numberOfCircularPrimes++; 
                        }
                }
                System.out.println(numberOfCircularPrimes);
                return numberOfCircularPrimes; 
        }
        public boolean checkCircular(int n){
                int count = 0, temp = n; 
                while(temp > 0){
                        count++; 
                        temp /= 10; 
                }
                int num = n; 
                while(isPrime(n))
                {
                        int rem = num % 10;
                        int div = num / 10; 
                        num = (int) ((Math.pow(10, count - 1)) * rem) + div; 
                        if(num == n); return true; 
                }
                return false; 
        }
        public boolean isPrime(int n )
        {
                if(n <= 1) return false;
                if(n <= 3) return true; 
                if( n % 2 == 0 || n % 3 == 0) return false; 
                for(int i = 5; i * i <= n; i = i + 6) 
                {
                        if(n % i == 0 || n % ( i + 2) == 0) return false; 
                }
                return true; 
        }

	public static void main(String[] args){
        projectEulerThree project = new projectEulerThree(); 
        // project.coinSums(); //< Solution: 73682 (31)
        // project.pandigitalProducts(); //< Solution : 45228 (32) 
        // project.digitFactorials(); //< Solution: 40730 (34) 
        project.circularPrimes(); //< Solution : 55 (35) 

	} 
}