class Program {
	// Best: O(nlog(n)) time | O(log(n)) space
	// Average: O(nlog(n)) time | O(log(n)) space
	// Worst: O(n^2) time | O(log(n)) space 
	public static int[] quickSortHelper(int[] array, int beginIndex, int endIndex){
		if(beginIndex < endIndex)
		{
			int partition = partition(array, beginIndex, endIndex);
			quickSortHelper(array, beginIndex, partition - 1);
			quickSortHelper(array, partition + 1, endIndex);
		}
		return array;
	}

	public static int partition(int[] array, int low, int high)
	{
		int pivot = array[high];
		int i = low - 1;
		for(int j = low; j <= high - 1; j++)
		{
			if(array[j] < pivot)
			{
				i++;
				int temp = array[j];
				int tempTwo = array[i];
				array[i] = temp;
				array[j] = tempTwo;
			}
		}
		int x = array[i + 1];
		int y = array[high];
		array[high] = x;
		array[i + 1] = y;
		return i + 1;
	}

  public static int[] quickSort(int[] array) {
    return quickSortHelper(array, 0, array.length - 1);
  }
}
