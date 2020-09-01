class MinStack {
    List<Integer> minStack = null; 

    /** initialize your data structure here. */
    public MinStack() {
        minStack = new ArrayList<Integer>(); 
    }
    
    public void push(int x) {
        minStack.add(x);
    }
    
    public void pop() {
        minStack.remove(minStack.size() - 1); 
        
    }
    
    public int top() {
        return minStack.get( minStack.size() - 1); 
        
    }
    
    public int getMin() {
        int min = minStack.get(0);
        for(int x: minStack)
        {
            if(x < min) min = x; 
        }
        return min; 
    }
}
