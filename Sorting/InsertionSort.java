class Program {
  public static int[] insertionSort(int[] array) {
		int currentIndex = 0; 
		int numberOfSwaps = 0;
		int start = 0;
		for(int i = 1; i < array.length; i++)
		{
			if(array[i] < array[start])
			{
				int temp = array[start];
				array[start] = array[i];
				array[i] = temp;
				numberOfSwaps++; 
				start++; 
			}
			
			if(array[i] >= array[start])
			{
				start++; 
			}
		}
		if(numberOfSwaps > 0)
		{
			insertionSort(array); 	
		}
		
		if(numberOfSwaps == 0)
		{
			return array; 	
		}
		
		return array; 
  }
}

