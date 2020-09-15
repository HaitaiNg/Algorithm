class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>(); 
        int[] returnArray = new int[T.length]; 
        for(int i = 0; i < T.length; i++)
        {
            while(!stack.isEmpty() && T[i] >T[stack.peek()])
            {
                int idx = stack.pop(); 
                returnArray[idx] = i - idx; 
            }
            stack.push(i); 
        }
        return returnArray; 
    }
}