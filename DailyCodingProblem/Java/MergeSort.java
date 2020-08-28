

//Best run time  O(nlog(n)) time | O(nlog(n)) space
//Average O(nlog(n)) time | O(nlog(n)) space
//Worst O(nlog(n)) time | O(nlog(n)) space 


class Program {

	public static void merge(int array[], int beginIndex, int middle, int endIndex)
	{
		//Create temporary arrays
		int L[] = new int[middle - beginIndex + 1];
		int R[] = new int[endIndex - middle];

		for(int i = 0; i < L.length; i++)
		{
			L[i] = array[beginIndex + i];
		}
		for(int j = 0; j < R.length; j++)
		{
			R[j] = array[middle + 1 + j];
		}

		//Merge the two temporary arrays
		int i = 0, j = 0;
		int k = beginIndex;
		while(i < L.length && j < R.length)
		{
			if(L[i] <= R[j])
			{
				array[k] = L[i];
				i++;
			}
			else
			{
				array[k] = R[j];
				j++;
			}
			k++;
		}

		//Copy remaining elements of L[] to array
		while(i < L.length)
		{
			array[k] = L[i];
			i++; k++;
		}
		while(j < R.length)
		{
			array[k] = R[j];
			j++; k++;
		}
	}


	public static void mergeSortHelper(int[] array, int beginIndex, int endIndex)
	{
		if(beginIndex < endIndex)
		{
			int middle = (beginIndex + endIndex) / 2;
			mergeSortHelper(array, beginIndex, middle);
			mergeSortHelper(array, middle + 1, endIndex);
			merge(array, beginIndex, middle, endIndex);
		}
	}

  public static int[] mergeSort(int[] array) {
		mergeSortHelper(array, 0, array.length - 1 );
		return array;
  }
}
