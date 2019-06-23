import java.util.*;

class Program {
  public static int[] findThreeLargestNumbers(int[] array) {
    Arrays.sort(array);
		int[] returnArray = new int[3];
		int index = 0;
		for(int i = array.length - 3; i < array.length; i++)
		{
			returnArray[index] = array[i];
			index++;
		}
		System.out.println(returnArray);
		return returnArray;
  }
}
