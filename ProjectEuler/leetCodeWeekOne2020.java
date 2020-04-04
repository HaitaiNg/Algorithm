import java.util.*;

public class leetCodeWeekOne2020{

    // 4.1.20 Single Number 
    public int singleNumber(int[] nums){
        int x = 0; 
        for(int i : nums){
            x ^= i; 
        }
        return x; 
    }

    // 4.2.20 Happy Number 
    public boolean isHappyNumberHelper(int n, Set<Integer> numberSet)
    {
        int sum = 0;
        while(n > 0){
            int digit = n % 10; 
            sum += (digit * digit); 
            n /= 10;
        }
        if(sum == 1) return true;
        else if (numberSet.contains(sum)) return false;
        else numberSet.add(sum); 
        
        return isHappyNumberHelper(sum, numberSet); 
    }
    public boolean isHappy(int n) {
        Set<Integer> numberSet = new HashSet<Integer>(); 
        numberSet.add(n); 
        return isHappyNumberHelper(n, numberSet); 
    }

    //4.3.20 Maximum Sub Array (Kadane's Algorithm) 
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return Integer.MIN_VALUE; 
        int currentWindowSum = nums[0]; 
        int largestSum = nums[0]; 
        for(int i = 1; i < nums.length; i++){
            currentWindowSum = Math.max(currentWindowSum + nums[i], nums[i]); 
            largestSum = Math.max(currentWindowSum, largestSum); 
        }
        return largestSum; 
    }
    //4.4.20
    public void moveZeroes(int[] nums) {
        int[] zeroArray = new int[nums.length]; 
        int position = 0; 
        for(int i : nums){
            if(i != 0){
                zeroArray[position] = i; 
                position++; 
            }
        }
        if(position != nums.length - 1){
            for(int i = position; i < nums.length; i++)
            {
                zeroArray[i] = 0;
            }
        }
        nums = zeroArray; 
        for(int x: nums)
        {
            System.out.print(x + " "); 
        }
        
    }



    //4.5.20
    //4.6.20
    //4.7.20 

    public static void main(String[] args){

        leetCodeWeekOne2020 object = new leetCodeWeekOne2020(); 
        //4.1.20 //< Solution = 4; 
        object.singleNumber(new int[] {4,1,2,1,2}); 
        //4.2.20 // < Solution = true 
        object.isHappy(19); 
        //4.4.20 // < Solution = 6 (input =[-2,1,-3,4,-1,2,1,-5,4]) : [4,-1,2,1] has the largest sum = 6.
        object.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,-4}); 
        //4.5.20 //< Solution = [1,3,12,0,0] : Input: [0,1,0,3,12]
        object.moveZeroes(new int[] {0,1,0,3,12});

    }
}