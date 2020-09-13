import java.util.ArrayList;
import java.util.*;

// i'm unsure how this is passing all the test cases
// this solution is not very optimal

class Program {
  public static ArrayList<Integer[]> threeNumberSum(int[] array, int targetSum) {
		ArrayList<Integer[]> newArrayList = new ArrayList<Integer[]>();
		HashMap<Integer, Integer> tempHashMap = new HashMap<Integer,Integer>();
		for(int i = 0; i < array.length; i++) // initialize the hash map
		{
			if(!tempHashMap.keySet().contains(array[i]))
				 {
					 tempHashMap.put(array[i], 1);
				 }
		}

		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array.length; j++)
			{
				if( array[i] != array[j])
				{
					int difference = targetSum - array[i] - array[j];
					if( (tempHashMap.keySet().contains(difference)) && (array[i] != difference) && (array[j] != difference))
					{
//						System.out.println(targetSum + "   " + array[i] + " " + array[j] + " " + difference);
						Integer[] returnArray = new Integer[] {array[i], array[j], difference};
						Arrays.sort(returnArray);
					//	newArrayList.add(returnArray);
						System.out.println(targetSum + "  " + array[i] + "  " + array[j] + "  " + difference);

					}

					}
			}
		}
		return newArrayList;
  }
}
