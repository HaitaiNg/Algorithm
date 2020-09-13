import java.util.*; 

class Program {
  public static int getNthFib(int n) {
		
		LinkedList<Integer> listOfNumbers = new LinkedList<Integer>(); 
		listOfNumbers.add(0);
		listOfNumbers.add(1); 
		if(n == 0)
		{
			return 0; 
		}
		if(n <= 2)
		{
			return listOfNumbers.get(n - 1); 
		}
		
		int index = 2; 
		int fibNumber = 0; 
		while(index < n)
		{
			listOfNumbers.add( listOfNumbers.get(index - 1) + listOfNumbers.get(index - 2));
			index++; 
		}
		return listOfNumbers.get(n - 1); 
  }
}

