import java.util.*;
import java.util.Arrays;

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
    //4.4.20 Move Zeroes
    public void moveZeroes(int[] nums) {
        // 1.) We must do this in-place without making a copy of the array 
        // 2.) minimize the total number of operations 
        int position = 0; 
        for(int i : nums){
            if(i != 0){
                nums[position] = i; 
                position++; 
            }
        }
        for(int j = position; j < nums.length; j++)
        {
            nums[j] = 0; 
        }
    }

    //4.5.20 Best Time To Buy And Sell Stock II
    public int maxProfit(int[] prices) {
        int profit = 0; 
        for(int i = 1; i < prices.length; i++)
        {
            profit += Math.max(0, prices[i] - prices[i - 1]); 
        }
        return profit; 
    }
    //4.6.20 Group Anagrams 
    public static String sortString(String text) {
        char[] chars = text.toCharArray(); 
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfAnagramsAndIndexes = new HashMap<String, List<String>>(); 
        List<List<String>> returnList = new ArrayList<List<String>>(); 
        for(String s : strs)
        {
            if(mapOfAnagramsAndIndexes.containsKey(sortString(s)))
            {
                List<String> temporaryList = mapOfAnagramsAndIndexes.get(sortString(s));
                temporaryList.add(s); 
                mapOfAnagramsAndIndexes.put(sortString(s), temporaryList); 
            }
            else
            {
                List<String> temporaryList = new ArrayList<String>(); 
                temporaryList.add(s); 
                mapOfAnagramsAndIndexes.put(sortString(s), temporaryList); 
            }
        }
        for(String K :mapOfAnagramsAndIndexes.keySet())
        {
            returnList.add(mapOfAnagramsAndIndexes.get(K)); 
        }
        return returnList; 
    }
    //4.7.20 Count Elements 
    public int countElements(int[] arr) {
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>(); 
        for(int entry: arr){
            numberMap.put(entry, entry + 1); 
        }
        int numberOfValidCounts = 0; 
        for(int x: arr){
            if(numberMap.containsKey(x + 1)) numberOfValidCounts++;
        }
        return numberOfValidCounts; 
    }

    public static void main(String[] args){

        leetCodeWeekOne2020 object = new leetCodeWeekOne2020(); 
        //4.1.20 //< Solution = 4; 
        object.singleNumber(new int[] {4,1,2,1,2}); 
        //4.2.20 // < Solution = true 
        object.isHappy(19); 
        //4.3.20 // < Solution = 6 (input =[-2,1,-3,4,-1,2,1,-5,4]) : [4,-1,2,1] has the largest sum = 6.
        object.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,-4}); 
        //4.4.20 //< Solution = [1,3,12,0,0] : Input: [0,1,0,3,12]
        object.moveZeroes(new int[] {0,1,0,3,12});
        //4.5.20   Best Time to Buy and Sell Stock II //<  Solution : 0 
        object.maxProfit((new int[] {7,6,4,3,1})); 
        //4.6.20
        String[] arguments = {"eat", "tea", "tan", "ate", "nat", "bat"}; 
        object.groupAnagrams(arguments); 
        //4.7.20 
        object.countElements(new int[] {1,3,2,3,5,0});

    }
}