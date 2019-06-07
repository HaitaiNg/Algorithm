
// Sort the array using an algorithm such as quickSort.
// Use two pointers ( one pointer at the left hand side, another pointer on the right hand side)
// Take the TargetSum - (value pointed at left || right side) == value pointed at left || right side 
// O(n) space , O(n) time 


import java.util.Arrays; 
import java.util.HashMap; 

class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
		Arrays.sort(array); // sort the array (small values -> large values) 
		int[] returnArray = new int[2]; 
		int difference; 
		int leftHandIndex = 0;
		int rightHandIndex = array.length - 1; 
		while(true)
		{
		int leftHandSide = array[leftHandIndex]; 
		int rightHandSide = array[rightHandIndex]; 
		
			if(leftHandIndex == rightHandIndex)
			{
				break; 
			}
			
			difference = leftHandSide + rightHandSide; 
			if(difference == targetSum)
			{
				returnArray[0] = leftHandSide;
				returnArray[1] = rightHandSide; 
				return returnArray; 
			}
			
			if(targetSum > difference)
			{
				leftHandIndex++; 
			}
			else
			{
				rightHandIndex--; 
			}
			
			
		}
		
    return new int[0]; 
  }
}