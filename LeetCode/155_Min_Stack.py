class MinStack:
    mystack = None 

    def __init__(self):
        self.mystack =[] 
        
        """
        initialize your data structure here.
        """
        

    def push(self, x: int) -> None:
        self.mystack.append(x) 
        

    def pop(self) -> None:
        self.mystack.pop() 
        

    def top(self) -> int:
        return self.mystack[len(self.mystack) - 1]
        

    def getMin(self) -> int:
        currentMin = float('inf')
        for value in self.mystack: 
            if value < currentMin:
                currentMin = value
        return currentMin 
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
