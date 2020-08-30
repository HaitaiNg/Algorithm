import java.lang.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> pastValues = new HashSet<Integer>(); 
        return isHappyHelper(n, pastValues); 
    }
    
    public boolean isHappyHelper(int n, Set<Integer> pastValues)
    {
        int currentSum = 0; 
        while(n > 0)
        {
            currentSum += Math.pow(n % 10, 2); 
            n /= 10; 
        }
        if(currentSum == 1) return true;
        if(pastValues.contains(currentSum)) return false; 
        pastValues.add(currentSum);
        return isHappyHelper(currentSum, pastValues); 
        
    }
}
