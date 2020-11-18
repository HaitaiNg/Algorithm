class MinStack {
public:
    vector<int> minStack; 
    MinStack() {
        minStack.clear(); 
    }
    
    void push(int x) {
        minStack.push_back(x); 
    }
    
    void pop() {
        minStack.pop_back(); 
    }
    
    int top() {
        return minStack[ minStack.size() - 1]; 
    }
    
    int getMin() {
        if(minStack.size() >= 0)
        {
            int minn = minStack[0]; 
            for(int c : minStack)
            {
                minn = std::min(minn, c); 
            }
            return minn;
        }
        return -1; 
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */