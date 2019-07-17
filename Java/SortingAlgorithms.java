
class Program
{
  // Binary search O(log(n)) time | O(log(n)) space
  public static int binarySearchHelper( int[] array, int target, int left, int right)
  {
  if (left > right)
  {
   return -1;
  }

  int midpoint = (left + right) / 2;
  int match = array[midpoint];
  if (target == match)
  {
  return midpoint;
  }
  else if (target < match)
  {
   return binarySearchHelper(array, target, left, midpoint - 1);
  }
  else
  {
   return binarySearchHelper(array, target, midpoint + 1, right);
  }
  }

  public static int binarySearch( int[] array, int target)
  {
  return binarySearchHelper(array, target, 0, array.length - 1);
  }

  // Bubble sort
  // Best O(n) time | O(1) space
  // Average O(n^2) time | O(1) space
  // Worst O(n^2) time | O(1) space
  public static int[] bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n -1; i++)
		{
			for(int j = 0; j < n - i - 1; j++)
			{
				if(array[j] > array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j+1] = temp;
				}
			}
		}

		return array;
  }



  // Insertion sort//
  // Best O(n) time | O(1) space
  // Average O(n^2) time | O(1) space
  // Worst O(n^2) time | O(1) space
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

  // Selection Sort
  // Best O(n^2) time | O(1) space
  // Average O(n^2) time | O(1) space
  // Worst O(n^2) time | O(1) space
  public static int[] selectionSort(int[] array) {
      int n = array.length;
      // One by one move boundary of unsorted subarray
      for (int i = 0; i < n-1; i++)
    {
  // Find the minimum element in unsorted array
  int min_idx = i;
  for (int j = i+1; j < n; j++)
      if (array[j] < array[min_idx])
    min_idx = j;

  // Swap the found minimum element with the first
  // element
  int temp = array[min_idx];
  array[min_idx] = array[i];
  array[i] = temp;
    }
return array;

  }


}
