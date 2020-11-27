class Solution:
    
    def maxVaried(self, customers, grumpy, X, i): 
        total = 0
        hope = False 
        for j in range(0, len(customers)):
            if j == i:
                hope = True 
            if(hope):
                total += customers[j]
                X -=1
                if(X <= 0):
                    hope = False 
            else:
                if grumpy[j] == 0:
                    total += customers[j] 
        return total 
                
    def maxSatisfied(self, customers: List[int], grumpy: List[int], X: int) -> int:
        total = 0 
        for i in range(0, len(customers)):
            total = max(total, self.maxVaried(customers, grumpy, X, i))
        return total 
            
        
    
        
            
        