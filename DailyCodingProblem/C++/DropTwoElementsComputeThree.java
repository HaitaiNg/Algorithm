import java.util.*;

class  Main{

  public static boolean loadBalancer(int[] A)
  {
    int[] sumMap = new int[A.length];
    int sum = 0;
    // count the accumulated sum from the left
    for(int i = 0; i < A.length; i ++) {
        sum += A[i];
        sumMap[i] = sum;
    }

    // use nested loop to get the subarray's start and endi ndex
    // calculate left, mid, right sum
    // 2.try each combination
    for(int i = 1; i < A.length - 1; i ++) {
        for(int j = i + 1; j < A.length - 1; j ++) {
            int left = sumMap[i] - A[i];
            int mid = sumMap[j] - sumMap[i] - A[j];
            int right = sumMap[A.length - 1] - sumMap[j];

            if(left == mid && mid == right)return true;
        }
      }
      return false;
  }


	public static void main(String[] args)
	{
    System.out.println(loadBalancer(new int[] {4,4,4})); // false
    System.out.println(loadBalancer(new int[] {1,2,3} )); //false
    System.out.println(loadBalancer(new int[] {1,3,4,2,2,2,1,1,2})); //true (your example)
    System.out.println(loadBalancer(new int[] {1,2,4,3,5,2,1})); // true
	}
}
