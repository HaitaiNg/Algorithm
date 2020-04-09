import java.util.*; 
import java.math.*; 
import java.math.BigInteger; 

public class projectEulerThree{

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

	public static void main(String[] args){
        projectEulerThree project = new projectEulerThree(); 
        project.pandigitalProducts(); //< Solution : 45228 (32) 
        project.digitFactorials(); //< Solution: 40730 (34) 

	} 
}