import java.util.*;
import java.math.*; 

public class leetCodeWeekThreeApril2020{

    // 4.15.20 Product Except Self (Medium) : I keep failing different test cases 
    public int[] productExceptSelf(int[] nums) {
        // The length of the input array
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R[length - 1] would be 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }

        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }

        return answer;
    }


    public static void main(String[] args){
        leetCodeWeekThreeApril2020 object = new leetCodeWeekThreeApril2020(); 
        object.productExceptSelf(new int[] {1,2,3,4}); //< solution : [24, 12, 8, 4] a
        // object.productExceptSelf(new int[] {9,0, -2}); //< solution : [24, 12, 8, 4] 

   }

}

