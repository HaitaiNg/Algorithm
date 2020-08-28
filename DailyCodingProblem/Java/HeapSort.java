class Program {
  public static int[] heapSort(int[] array) {
		// Begin by creating max heap
		// Perform swaps and reposition array elements

    // Best: O(nlog(n)) time | O(1) space
		// Average: O(nlog(n)) time | O(1) space
		// Worst: O(nlog(n)) time | O(1) space
			buildMaxHeap(array);
			for(int endIndex = array.length - 1; endIndex > 0; endIndex--)
			{
				swap(0, endIndex, array);
				siftDown(0, endIndex - 1, array);
			}
			return array;
		}

		// transform array into a max heap
		public static void buildMaxHeap(int[] array)
		{
			int firstParentIndex = (array.length - 2) / 2;
			for(int currentIndex = firstParentIndex; currentIndex >= 0; currentIndex--)
			{
				siftDown(currentIndex, array.length - 1, array);
			}
		}

		public static void siftDown(int currentIdx, int endIdx, int[] heap)
		{
			int childOneIdx = currentIdx * 2 + 1;
			while(childOneIdx <= endIdx)
			{
				int childTwoIdx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
				int idxToSwap;
				if(childTwoIdx != -1 && heap[childTwoIdx] > heap[childOneIdx])
				{
					idxToSwap = childTwoIdx;
				}
				else
				{
					idxToSwap = childOneIdx;
				}
				if(heap[idxToSwap] > heap[currentIdx])
				{
					swap(currentIdx, idxToSwap, heap);
					currentIdx = idxToSwap;
					childOneIdx = currentIdx * 2 + 1;

				}else
				{
					return;
				}
			}
		}

		public static void swap(int i, int j, int[] array)
		{
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}
	}
