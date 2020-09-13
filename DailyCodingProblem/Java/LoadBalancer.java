import java.util.*;

class  Main{

// inputArray will consit of the array with the two numbers removed
// Everything to the left of leftPointer = arrayOne
// Everything in between [leftPointer, rightPointer]  = arrayTwo
// Everything to the right of [rightPointer, end] = arrayThree
  public static boolean calculateThreeArray(int[] inputArray, int leftPointer, int rightPointer)
  {
    int arrayOne = 0 , arrayTwo = 0, arrayThree = 0;
    for(int i = 0; i < inputArray.length; i++)
    {
        if(i < leftPointer)
        {
          arrayOne = arrayOne + inputArray[i];
        }
        else if((i >= leftPointer) && (i < rightPointer))
        {
          arrayTwo = arrayTwo + inputArray[i];
        }
        else
        {
          arrayThree = arrayThree + inputArray[i];
        }
    }
    if(arrayOne != arrayTwo) return false;
    return arrayTwo == arrayThree ? true : false;
  }



  public static boolean loadBalancer(int[] inputArray)
  {
    int arraySize = inputArray.length;
    // base case
    if(arraySize < 3) return false;
    if(arraySize == 3) return calculateThreeArray(inputArray, 1, 2);

    int total = 0;
    for(int i = 0; i < arraySize; i++)
    {
      total = total + inputArray[i];
    }
    // how do i determine what two numbers i should remove
    // calculate whether you can create three subarrays after
    // removing the two numbers
    
    if(total / 3 == 0)
    return false;
  }


	public static void main(String[] args)
	{
    System.out.println(loadBalancer(new int[] {4,4,4};)); // true
    System.out.println(loadBalancer(new int[] {1,2,3} )); //false
    System.out.println(loadBalancer(new int[] {1,3,4,2,2,2,1,1,2})); //true
	}
}
