import java.util.*;
import java.math.*; 

public class leetCodeWeekThreeApril2020{

    // 4.15.20 Product Except Self (Medium) : I keep failing different test cases 
    public int[] productExceptSelf(int[] nums) {

        //Solution inspired by Errchito (Prefix sums and suffix sums)
        int n = nums.length; 
        int[] pref_product = new int[n + 1];
        pref_product[0] = 1; 
        int lastElement = 0; 
        int index = 1; 
        for(int x: nums)
        {
            pref_product[index] = pref_product[lastElement] * x;
            index++; lastElement++; 
            
        }
        int[] suf_product = new int[ n + 1]; 
        suf_product[n] = 1; 
        for(int i = n - 1; i >= 0; --i)
        {
            suf_product[i] = suf_product[i + 1] * nums[i]; 
        }
        int[] returnArray = new int[n];
        for(int i = 0; i < n; i++)
        {
            returnArray[i] = pref_product[i] * suf_product[i + 1];
        }
        return returnArray; 

        // The length of the input array
        // int length = nums.length;
        // int[] L = new int[length];
        // int[] R = new int[length];
        // int[] answer = new int[length];
        // L[0] = 1;
        // for (int i = 1; i < length; i++) {

        //     // L[i - 1] already contains the product of elements to the left of 'i - 1'
        //     // Simply multiplying it with nums[i - 1] would give the product of all
        //     // elements to the left of index 'i'
        //     L[i] = nums[i - 1] * L[i - 1];
        // }

        // // R[i] contains the product of all the elements to the right
        // // Note: for the element at index 'length - 1', there are no elements to the right,
        // // so the R[length - 1] would be 1
        // R[length - 1] = 1;
        // for (int i = length - 2; i >= 0; i--) {

        //     // R[i + 1] already contains the product of elements to the right of 'i + 1'
        //     // Simply multiplying it with nums[i + 1] would give the product of all
        //     // elements to the right of index 'i'
        //     R[i] = nums[i + 1] * R[i + 1];
        // }

        // // Constructing the answer array
        // for (int i = 0; i < length; i++) {
        //     // For the first element, R[i] would be product except self
        //     // For the last element of the array, product except self would be L[i]
        //     // Else, multiple product of all elements to the left and to the right
        //     answer[i] = L[i] * R[i];
        // }

        // return answer;
    }

    //4.16.20 Valid Parentheses String (Dynamic Programming) 
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
         for (char c: s.toCharArray()) {
             lo += c == '(' ? 1 : -1;
             hi += c != ')' ? 1 : -1;
             if (hi < 0) break;
             lo = Math.max(lo, 0);
         }
         return lo == 0;
      }


      // Search a 2d matrix
      // 4.16.20 
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null) return false; 
            if(matrix.length == 0) return false; 
            
            int row = 0;
            int col = matrix[0].length - 1; 
            while(row < matrix.length && col >= 0)
            {
                if(matrix[row][col] > target) col--;
                else if(matrix[row][col] < target) row++; 
                else return true; 
            }
            return false; 
        }

      public int[][] matrix = {
        {1, 4, 7, 12, 15, 1000},
        {2, 5, 19, 31, 32, 1001},
        {3, 8, 24, 33, 35, 1002},
        {40, 41, 42, 44, 45, 1003},
        {99, 100, 103, 106, 128, 1004},
      };

    public static void main(String[] args){
        // leetCodeWeekThreeApril2020 object = new leetCodeWeekThreeApril2020(); 
        // object.productExceptSelf(new int[] {1,2,3,4}); //< solution : [24, 12, 8, 4] a
        // object.productExceptSelf(new int[] {9,0, -2}); //< solution : [24, 12, 8, 4] 
        // searchMatrix(object.matrix, -1);
        // searchInSortedMatrix(object.matrix, 1004); 
   }

}

//4.20.20 Construct Binary Search Tree 
