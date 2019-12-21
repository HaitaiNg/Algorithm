// O(log(n)) time | O(log(n)) space 
class Program
{
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
}
