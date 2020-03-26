import java.util.*; 
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

	public static void main(String[] args) throws Exception{
		//  amicableNumbers(); //< Solution: 852810
		//  namesScores(); //< Solution: 871198282
		}

}
