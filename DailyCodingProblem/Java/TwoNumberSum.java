import java.util.*;
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    Arrays.sort(array);
		int leftHandPointer = 0;
		int rightHandPointer = array.length - 1;
		while(leftHandPointer < rightHandPointer)
		{
			int summ =  array[leftHandPointer] + array[rightHandPointer];
			if(summ == targetSum)
			{
				return new int[] {array[leftHandPointer], array[rightHandPointer]};
			}
			else if( summ > targetSum)
			{
				rightHandPointer--;
			}
			else
			{
				leftHandPointer++;
			}
		}
		return new int[0];
  }
}
