import java.util.*;

class Program {
	// O(n^2) time | O(n^2) space - where n is the number of nodes in each array
  public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
    if(arrayOne.size() != arrayTwo.size())
		{
			return false;
		}
		if(arrayOne.size() == 0 && arrayTwo.size() == 0) return true;
		if(arrayOne.get(0).intValue() != arrayTwo.get(0).intValue()) return false;
		List<Integer> leftOne = getSmaller(arrayOne);
		List<Integer> leftTwo = getSmaller(arrayTwo);
		List<Integer> rightOne = getBiggerOrEqual(arrayOne);
		List<Integer> rightTwo = getBiggerOrEqual(arrayTwo);
		return sameBsts(leftOne, leftTwo) && sameBsts(rightOne, rightTwo);
  }


	public static List<Integer> getSmaller(List<Integer> array)
	{
		List<Integer> smaller = new ArrayList<Integer>();
		for(int i = 1; i < array.size(); i++)
		{
			if(array.get(i).intValue() < array.get(0).intValue()) smaller.add(array.get(i));
		}
		return smaller;
	}

	public static List<Integer> getBiggerOrEqual(List<Integer> array)
	{
		List<Integer> biggerOrEqual = new ArrayList<Integer>();
		for(int i = 1; i < array.size(); i++)
		{
			if(array.get(i).intValue() >= array.get(0).intValue()) biggerOrEqual.add(array.get(i));
		}
		return biggerOrEqual;
	}




}
